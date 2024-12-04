package com.example.assignment_ChatGPT.Services;

import com.example.assignment_ChatGPT.DTOs.PetDTO;
import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Entities.Pet;
import com.example.assignment_ChatGPT.Repositories.HouseholdRepository;
import com.example.assignment_ChatGPT.Repositories.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {
    private final PetRepository petRepository;
    private final HouseholdRepository householdRepository;

    public List<PetDTO> getAllPets() {
        return petRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PetDTO createPet(PetDTO petDTO) {
        Household household = householdRepository.findById(petDTO.householdId())
                .orElseThrow(() -> new IllegalArgumentException("Household not found"));

        Pet pet = new Pet();
        pet.setName(petDTO.name());
        pet.setType(petDTO.type());
        pet.setAge(petDTO.age());
        pet.setHousehold(household);

        Pet savedPet = petRepository.save(pet);
        return convertToDTO(savedPet);
    }

    public PetDTO updatePet(Long id, PetDTO petDTO) {
        Pet existingPet = petRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pet not found"));

        existingPet.setName(petDTO.name());
        existingPet.setType(petDTO.type());
        existingPet.setAge(petDTO.age());

        Pet updatedPet = petRepository.save(existingPet);
        return convertToDTO(updatedPet);
    }

    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            throw new IllegalArgumentException("Pet not found");
        }
        petRepository.deleteById(id);
    }

    public List<PetDTO> getPetsByHousehold(Long householdId) {
        return petRepository.findByHouseholdId(householdId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PetDTO convertToDTO(Pet pet) {
        return new PetDTO(
                pet.getId(),
                pet.getName(),
                pet.getType(),
                pet.getAge(),
                pet.getHousehold() != null ? pet.getHousehold().getId() : null
        );
    }
}
