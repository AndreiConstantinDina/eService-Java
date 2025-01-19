package com.example.eservice.controller;

import com.example.eservice.model.Vehicle;
import com.example.eservice.repository.VehicleRepository;
import com.example.eservice.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository repository;

    @Autowired
    private VehicleService vehicleService;

    @Operation(
            summary = "Retrieve all vehicles",
            description = "Fetches a list of all vehicles stored in the system, including their details such as brand, model, fuel type, and more."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of vehicles"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    @Operation(
            summary = "Create a new vehicle",
            description = "Adds a new vehicle to the system. The request body should include all the required details of the vehicle."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the vehicle"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Vehicle createVehicle(
            @Parameter(description = "Vehicle object to be created", required = true)
            @RequestBody Vehicle vehicle
    ) {
        return repository.save(vehicle);
    }

    @Operation(
            summary = "Delete a vehicle",
            description = "Deletes a vehicle from the system using its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the vehicle"),
            @ApiResponse(responseCode = "404", description = "Vehicle not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void deleteVehicle(
            @Parameter(description = "ID of the vehicle to be deleted", required = true)
            @PathVariable Long id
    ) {
        repository.deleteById(id);
    }

    @Operation(
            summary = "Search vehicles by brand",
            description = "Fetches all vehicles that match the specified brand."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved vehicles for the specified brand"),
            @ApiResponse(responseCode = "400", description = "Invalid brand parameter"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/search")
    public List<Vehicle> searchVehiclesByBrand(
            @Parameter(description = "Brand of the vehicles to search for", required = true)
            @RequestParam String brand
    ) {
        return vehicleService.searchByBrand(brand);
    }
}
