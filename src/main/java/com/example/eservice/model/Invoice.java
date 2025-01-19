package com.example.eservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Repair repair;

    private Date issueDate;
    private double totalCost;
    private boolean isPaid;

    public Invoice(long l, Object o, double v, boolean b) {
        id = l;
        repair = (Repair) o;
        totalCost = v;
        isPaid = b;
        issueDate = new Date();
    }

    public Invoice() {

    }

    // Getters and Setters
}