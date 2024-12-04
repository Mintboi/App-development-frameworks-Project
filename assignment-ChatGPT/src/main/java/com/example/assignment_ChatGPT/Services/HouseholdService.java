package com.example.assignment_ChatGPT.Services;

import com.example.assignment_ChatGPT.DTOs.HouseholdDTO;
import com.example.assignment_ChatGPT.DTOs.PetDTO;
import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Entities.Pet;
import com.example.assignment_ChatGPT.Repositories.HouseholdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    public List<HouseholdDTO> getAllHouseholds() {
        return householdRepository.findAll().stream()
                .map(household -> new HouseholdDTO(
                        household.getId(),
                        household.getName(),
                        household.getAddress(),
                        household.getPets().stream()
                                .map(pet -> new PetDTO(pet.getId(), pet.getName(), pet.getType(), pet.getAge(), pet.getHousehold().getId()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public HouseholdDTO getHouseholdById(Long id) {
        Household household = householdRepository.findById(id).orElseThrow(() -> new RuntimeException("Household not found"));
        return new HouseholdDTO(
                household.getId(),
                household.getName(),
                household.getAddress(),
                household.getPets().stream()
                        .map(pet -> new PetDTO(pet.getId(), pet.getName(), pet.getType(), pet.getAge(), pet.getHousehold().getId()))
                        .collect(Collectors.toList())
        );
    }

    public HouseholdDTO createHousehold(HouseholdDTO householdDTO) {
        Household household = new Household();
        household.setName(householdDTO.name());
        household.setAddress(householdDTO.address());

        // Map pets from DTO if present
        if (householdDTO.pets() != null) {
            List<Pet> pets = householdDTO.pets().stream().map(petDTO -> {
                Pet pet = new Pet();
                pet.setName(petDTO.name());
                pet.setType(petDTO.type());
                pet.setAge(petDTO.age());
                pet.setHousehold(household);
                return pet;
            }).collect(Collectors.toList());
            household.setPets(pets);
        }

        Household savedHousehold = householdRepository.save(household);

        return new HouseholdDTO(
                savedHousehold.getId(),
                savedHousehold.getName(),
                savedHousehold.getAddress(),
                savedHousehold.getPets().stream()
                        .map(pet -> new PetDTO(pet.getId(), pet.getName(), pet.getType(), pet.getAge(), pet.getHousehold().getId()))
                        .collect(Collectors.toList())
        );
    }
}
