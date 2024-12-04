package com.example.assignment_ChatGPT.DTOs;

import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Entities.Pet;
import com.example.assignment_ChatGPT.Repositories.HouseholdRepository;
import com.example.assignment_ChatGPT.Repositories.PetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final HouseholdRepository householdRepository;
    private final PetRepository petRepository;

    public DataInitializer(HouseholdRepository householdRepository, PetRepository petRepository) {
        this.householdRepository = householdRepository;
        this.petRepository = petRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        householdRepository.deleteAll();
        petRepository.deleteAll();

        Household household1 = new Household();
        household1.setName("Smith Family");
        household1.setAddress("123 Main St");

        Household household2 = new Household();
        household2.setName("Johnson Family");
        household2.setAddress("456 Elm St");

        householdRepository.saveAll(Arrays.asList(household1, household2));

        Pet pet1 = new Pet();
        pet1.setName("Buddy");
        pet1.setType("Dog");
        pet1.setAge(5);
        pet1.setHousehold(household1);

        Pet pet2 = new Pet();
        pet2.setName("Mittens");
        pet2.setType("Cat");
        pet2.setAge(3);
        pet2.setHousehold(household2);

        petRepository.saveAll(Arrays.asList(pet1, pet2));
    }
}
