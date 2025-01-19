package com.example.eservice.controller;

import com.example.eservice.model.Part;
import com.example.eservice.model.Repair;
import com.example.eservice.repository.RepairRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repairs")
public class RepairController {

    @Autowired
    private RepairRepository repository;

    @Operation(
            summary = "Retrieve all repairs",
            description = "Fetches a list of all repairs stored in the system, including details such as repair value, mechanic, and vehicle."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of repairs"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Repair> getAllRepairs() {
        return repository.findAll();
    }

    @Operation(
            summary = "Create a new repair",
            description = "Adds a new repair to the system. The request body should include all required details of the repair."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the repair"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Repair createRepair(
            @Parameter(description = "Repair object to be created", required = true)
            @RequestBody Repair repair
    ) {
        return repository.save(repair);
    }

    @Operation(
            summary = "Delete a repair",
            description = "Deletes a repair from the system using its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the repair"),
            @ApiResponse(responseCode = "404", description = "Repair not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void deleteRepair(
            @Parameter(description = "ID of the repair to be deleted", required = true)
            @PathVariable Long id
    ) {
        repository.deleteById(id);
    }

    @Operation(
            summary = "Get parts for a repair",
            description = "Fetches all parts associated with a specific repair using the repair ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved parts for the repair"),
            @ApiResponse(responseCode = "404", description = "Repair not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}/parts")
    public List<Part> getPartsForRepair(
            @Parameter(description = "ID of the repair whose parts are to be fetched", required = true)
            @PathVariable Long id
    ) {
        return repository.findById(id)
                .map(Repair::getParts)
                .orElseThrow(() -> new RuntimeException("Repair not found"));
    }
}
