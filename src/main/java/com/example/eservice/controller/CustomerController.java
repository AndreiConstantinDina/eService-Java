package com.example.eservice.controller;


import com.example.eservice.model.Customer;
import com.example.eservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.eservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping
    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers.")
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @PostMapping
    @Operation(summary = "Add a new customer", description = "Create a new customer and save it to the database.")

    public Customer createCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer", description = "Create the customer with the passed id.")

    public void deleteCustomer(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @Autowired
    private CustomerService customerService;

    @GetMapping("/search")
    @Operation(summary = "Search customers by email", description = "Retrieve customers whose emails match the specified query.")
    public List<Customer> searchCustomersByEmail(@RequestParam String email) {
        return customerService.searchByEmail(email);
    }

}