package com.example.assignment_ChatGPT.Controllers;

import com.example.assignment_ChatGPT.DTOs.HouseholdDTO;
import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping
    public HouseholdDTO createHousehold(@Valid @RequestBody HouseholdDTO householdDTO) {
        return householdService.createHousehold(householdDTO);
    }

    @GetMapping
    public List<HouseholdDTO> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }
}
