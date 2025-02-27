package com.example.eservice.repository;

import com.example.eservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByEmailContainingIgnoreCase(String email);
}