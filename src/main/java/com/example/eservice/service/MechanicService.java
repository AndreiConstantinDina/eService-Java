package com.example.eservice.service;

import com.example.eservice.model.Repair;
import com.example.eservice.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class MechanicService {
    @Autowired
    private RepairRepository repairRepository;

    public double calculateProfitForMechanic(Long mechanicId) {
        // Get the start and end of the current month as LocalDate
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        LocalDate endOfMonth = startOfMonth.plusMonths(1).minusDays(1);

        // Convert LocalDate to java.util.Date
        Date startDate = Date.from(startOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(endOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Query repairs and calculate profit
        List<Repair> repairs = repairRepository.findByMechanicIdAndDateBetween(mechanicId, startDate, endDate);

        return repairs.stream()
                .mapToDouble(Repair::getRepairValue)
                .sum();
    }
}
