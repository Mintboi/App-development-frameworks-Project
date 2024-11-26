package com.example.assignment_ChatGPT.GraphQL;

import com.example.assignment_ChatGPT.Entities.Pet;
import com.example.assignment_ChatGPT.Services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PetGraphQLController {
    private final PetService petService;

    @QueryMapping
    public Iterable<Pet> allPets() {
        return petService.getAllPets();
    }

    @MutationMapping
    public Pet createPet(Pet pet) {
        return petService.createPet(pet);
    }
}
