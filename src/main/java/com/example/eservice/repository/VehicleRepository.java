package com.example.eservice.repository;

import com.example.eservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByBrandContainingIgnoreCase(String brand);

}