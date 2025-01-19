package com.example.eservice.service;


import com.example.eservice.model.Vehicle;
import com.example.eservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> searchByBrand(String brand) {
        return vehicleRepository.findByBrandContainingIgnoreCase(brand);
    }
}