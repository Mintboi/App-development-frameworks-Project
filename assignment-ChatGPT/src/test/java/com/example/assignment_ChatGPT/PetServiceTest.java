package com.example.assignment_ChatGPT.Services;

import com.example.assignment_ChatGPT.DTOs.PetDTO;
import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Entities.Pet;
import com.example.assignment_ChatGPT.Repositories.HouseholdRepository;
import com.example.assignment_ChatGPT.Repositories.PetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Test
    public void testGetAllPets() {
        PetRepository petRepo = Mockito.mock(PetRepository.class);
        HouseholdRepository householdRepo = Mockito.mock(HouseholdRepository.class);
        PetService petService = new PetService(petRepo, householdRepo);

        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Buddy");
        pet.setType("Dog");
        pet.setAge(5);

        when(petRepo.findAll()).thenReturn(List.of(pet));

        List<PetDTO> pets = petService.getAllPets();

        assertEquals(1, pets.size());
        assertEquals("Buddy", pets.get(0).name());
    }

    @Test
    public void testCreatePet() {
        PetRepository petRepo = Mockito.mock(PetRepository.class);
        HouseholdRepository householdRepo = Mockito.mock(HouseholdRepository.class);
        PetService petService = new PetService(petRepo, householdRepo);

        Household household = new Household(1L, "Smith Family", "123 Main St", Collections.emptyList());
        when(householdRepo.findById(1L)).thenReturn(Optional.of(household));

        PetDTO petDTO = new PetDTO(null, "Buddy", "Dog", 5, 1L);

        Pet savedPet = new Pet();
        savedPet.setId(1L);
        savedPet.setName("Buddy");
        savedPet.setType("Dog");
        savedPet.setAge(5);
        savedPet.setHousehold(household);

        when(petRepo.save(any(Pet.class))).thenReturn(savedPet);

        PetDTO result = petService.createPet(petDTO);

        assertNotNull(result.id());
        assertEquals("Buddy", result.name());
    }

    @Test
    public void testUpdatePet() {
        PetRepository petRepo = Mockito.mock(PetRepository.class);
        HouseholdRepository householdRepo = Mockito.mock(HouseholdRepository.class);
        PetService petService = new PetService(petRepo, householdRepo);

        Pet existingPet = new Pet();
        existingPet.setId(1L);
        existingPet.setName("Buddy");
        existingPet.setType("Dog");
        existingPet.setAge(5);

        when(petRepo.findById(1L)).thenReturn(Optional.of(existingPet));

        PetDTO petDTO = new PetDTO(1L, "Buddy Updated", "Dog", 6, null);

        Pet updatedPet = new Pet();
        updatedPet.setId(1L);
        updatedPet.setName("Buddy Updated");
        updatedPet.setType("Dog");
        updatedPet.setAge(6);

        when(petRepo.save(existingPet)).thenReturn(updatedPet);

        PetDTO result = petService.updatePet(1L, petDTO);

        assertEquals("Buddy Updated", result.name());
        assertEquals(6, result.age());
    }

    @Test
    public void testDeletePet() {
        PetRepository petRepo = Mockito.mock(PetRepository.class);
        HouseholdRepository householdRepo = Mockito.mock(HouseholdRepository.class);
        PetService petService = new PetService(petRepo, householdRepo);

        when(petRepo.existsById(1L)).thenReturn(true);

        petService.deletePet(1L);

        verify(petRepo, times(1)).deleteById(1L);
    }

    @Test
    public void testGetPetsByHousehold() {
        PetRepository petRepo = Mockito.mock(PetRepository.class);
        HouseholdRepository householdRepo = Mockito.mock(HouseholdRepository.class);
        PetService petService = new PetService(petRepo, householdRepo);

        Pet pet = new Pet();
        pet.setId(1L);
        pet.setName("Buddy");
        pet.setType("Dog");
        pet.setAge(5);

        when(petRepo.findByHouseholdId(1L)).thenReturn(List.of(pet));

        List<PetDTO> pets = petService.getPetsByHousehold(1L);

        assertEquals(1, pets.size());
        assertEquals("Buddy", pets.get(0).name());
    }
}
