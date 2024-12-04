package com.example.assignment_ChatGPT.GraphQL;

import com.example.assignment_ChatGPT.DTOs.PetDTO;
import com.example.assignment_ChatGPT.Services.PetService;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetGraphQLController {
    private final PetService petService;

    public PetGraphQLController(PetService petService) {
        this.petService = petService;
    }

    @QueryMapping
    public List<PetDTO> getAllPets() {
        return petService.getAllPets();
    }

    @MutationMapping
    public PetDTO createPet(PetDTO petDTO) {
        return petService.createPet(petDTO);
    }
}
