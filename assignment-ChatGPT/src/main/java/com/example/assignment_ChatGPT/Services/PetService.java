package com.example.assignment_ChatGPT.Services;

import com.example.assignment_ChatGPT.Entities.Pet;
import com.example.assignment_ChatGPT.Repositories.PetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {
    private final PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet updatePet(Long id, Pet pet) {
        Pet existingPet = petRepository.findById(id).orElseThrow();
        existingPet.setName(pet.getName());
        existingPet.setType(pet.getType());
        existingPet.setAge(pet.getAge());
        return petRepository.save(existingPet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
