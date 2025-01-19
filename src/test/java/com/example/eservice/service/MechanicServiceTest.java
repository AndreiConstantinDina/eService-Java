package com.example.eservice.service;

import com.example.eservice.model.Mechanic;
import com.example.eservice.model.Repair;
import com.example.eservice.repository.RepairRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class MechanicServiceTest {

    @InjectMocks
    private MechanicService mechanicService;

    @Mock
    private RepairRepository repairRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCalculateProfitForMechanic() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date startOfMonth = calendar.getTime();

        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date endOfMonth = calendar.getTime();

        // Create a mechanic
        Mechanic mechanic = new Mechanic(1L, "John Mechanic", 3000.0);

        // Create repairs and associate them with the mechanic
        Repair repair1 = new Repair(1L, mechanic, null, null, 2700.0, startOfMonth);
        Repair repair2 = new Repair(2L, mechanic, null, null, 300.0, endOfMonth);

        when(repairRepository.findByMechanicIdAndDateBetween(1L, startOfMonth, endOfMonth))
                .thenReturn(Arrays.asList(repair1, repair2));

        // Act
        double profit = mechanicService.calculateProfitForMechanic(1L);

        // Assert
        assertThat(profit).isEqualTo(0);
    }
}
