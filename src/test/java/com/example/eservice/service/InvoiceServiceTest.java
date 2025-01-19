package com.example.eservice.service;

import com.example.eservice.model.Invoice;
import com.example.eservice.repository.InvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class InvoiceServiceTest {

    @InjectMocks
    private InvoiceService invoiceService;

    @Mock
    private InvoiceRepository invoiceRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllInvoices() {
        // Arrange
        Invoice invoice1 = new Invoice(1L, null, 150.0, true);
        Invoice invoice2 = new Invoice(2L, null, 250.0, false);

        when(invoiceRepository.findAll()).thenReturn(Arrays.asList(invoice1, invoice2));

        // Act
        List<Invoice> invoices = invoiceService.getAllInvoices();

        // Assert
        assertThat(invoices).hasSize(2);
        assertThat(invoices).extracting(Invoice::getTotalCost).containsExactly(150.0, 250.0);
    }
}
