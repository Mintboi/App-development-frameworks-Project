package com.example.assignment_ChatGPT.Controllers;

import com.example.assignment_ChatGPT.DTOs.PetDTO;
import com.example.assignment_ChatGPT.Services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public PetDTO createPet(@RequestBody PetDTO petDTO) {
        return petService.createPet(petDTO);
    }

    @GetMapping("/household/{householdId}")
    public List<PetDTO> getPetsByHousehold(@PathVariable Long householdId) {
        return petService.getPetsByHousehold(householdId);
    }
}
