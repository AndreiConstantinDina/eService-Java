package com.example.eservice.service;

import com.example.eservice.model.Customer;
import com.example.eservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize Mockito mocks
    }

    @Test
    void testSearchByEmail() {
        // Arrange
        Customer customer1 = new Customer(1L, "John Doe", "1234567890", "john.doe@example.com");
        Customer customer2 = new Customer(2L, "Jane Doe", "9876543210", "jane.doe@example.com");

        when(customerRepository.findByEmailContainingIgnoreCase("doe"))
                .thenReturn(Arrays.asList(customer1, customer2));

        // Act
        List<Customer> customers = customerService.searchByEmail("doe");

        // Assert
        assertThat(customers).hasSize(2);
        assertThat(customers).extracting(Customer::getName).containsExactly("John Doe", "Jane Doe");
    }
}
