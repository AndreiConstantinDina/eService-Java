package com.example.eservice.controller;

import com.example.eservice.model.Part;
import com.example.eservice.service.PartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartController {

    @Autowired
    private PartService partService;

    @Operation(
            summary = "Retrieve all parts",
            description = "Fetches a list of all parts stored in the system, including their details such as name, manufacturer, cost, and stock quantity."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of parts"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Part> getAllParts() {
        return partService.getAllParts();
    }

    @Operation(
            summary = "Add a new part",
            description = "Adds a new part to the system. The request body should include all required details of the part, such as name, manufacturer, cost, and stock quantity."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully added the part"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public Part addPart(
            @Parameter(description = "Part object to be added", required = true)
            @RequestBody Part part
    ) {
        return partService.addPart(part);
    }

    @Operation(
            summary = "Delete a part",
            description = "Deletes a part from the system using its ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted the part"),
            @ApiResponse(responseCode = "404", description = "Part not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public void deletePart(
            @Parameter(description = "ID of the part to be deleted", required = true)
            @PathVariable Long id
    ) {
        partService.deletePart(id);
    }
}
