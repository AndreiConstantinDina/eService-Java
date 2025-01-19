package com.example.eservice.controller;

import com.example.eservice.model.Invoice;
import com.example.eservice.service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Operation(
            summary = "Retrieve all invoices",
            description = "Fetches a list of all invoices stored in the system."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of invoices"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @Operation(
            summary = "Create a new invoice",
            description = "Adds a new invoice to the system. The request body should include all the required details of the invoice."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the invoice"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Invoice createInvoice(
            @Parameter(description = "Invoice object to be created", required = true)
            @RequestBody Invoice invoice
    ) {
        return invoiceService.createInvoice(invoice);
    }

    @Operation(
            summary = "Delete an invoice",
            description = "Deletes an invoice from the system using its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the invoice"),
            @ApiResponse(responseCode = "404", description = "Invoice not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void deleteInvoice(
            @Parameter(description = "ID of the invoice to be deleted", required = true)
            @PathVariable Long id
    ) {
        invoiceService.deleteInvoice(id);
    }
}
