package com.example.eservice.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String manufacturer;
    private double cost;
    private int stock;

    @ManyToMany
    @JoinTable(
            name = "repair_part",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "repair_id")
    )
    private List<Repair> repairs;

    // Getters and Setters
}