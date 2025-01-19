package com.example.eservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Mechanic")
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;

    public Mechanic(long l, String n, double v) {
        id = l;
        name = n;
        salary = v;
    }

    public Mechanic() {

    }
}