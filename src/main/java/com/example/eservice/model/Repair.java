package com.example.eservice.model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Repair")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Mechanic mechanic;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Vehicle vehicle;

    private Date date;
    private Double repairValue;

    @ManyToMany(mappedBy = "repairs")
    private List<Part> parts;


    public Repair() {

    }

    public Repair(long l, Object o, Object o1, Object o2, double v, Date startOfMonth) {
        id = l;
        mechanic = (Mechanic) o;
        customer = (Customer) o1;
        vehicle = (Vehicle) o2;
        date = startOfMonth;
        repairValue = v;
    }
}