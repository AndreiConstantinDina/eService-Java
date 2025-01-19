package com.example.eservice.repository;

import com.example.eservice.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> findByMechanicIdAndDateBetween(Long mechanicId, Date startDate, Date endDate);

}