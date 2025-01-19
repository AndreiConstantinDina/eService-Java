package com.example.eservice.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String brand;
    private String model;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private Integer kilometers;
    private Integer horsePower;
}