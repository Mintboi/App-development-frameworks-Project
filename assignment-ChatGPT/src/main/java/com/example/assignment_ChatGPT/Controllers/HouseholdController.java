package com.example.assignment_ChatGPT.Controllers;

import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Services.HouseholdService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/households")
@RequiredArgsConstructor
public class HouseholdController {
    private final HouseholdService householdService;

    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody Household household) {
        return ResponseEntity.ok(householdService.createHousehold(household));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Household> updateHousehold(@PathVariable Long id, @Valid @RequestBody Household household) {
        return ResponseEntity.ok(householdService.updateHousehold(id, household));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable Long id) {
        householdService.deleteHousehold(id);
        return ResponseEntity.noContent().build();
    }
}
