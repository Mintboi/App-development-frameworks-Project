package com.example.assignment_ChatGPT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.assignment_ChatGPT.Repositories.HouseholdRepository;
import com.example.assignment_ChatGPT.DTOs.HouseholdDTO;
import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Entities.Pet;
import com.example.assignment_ChatGPT.Services.HouseholdService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

public class HouseholdServiceTest {
    @Test
    public void testGetAllHouseholds() {
        // Mock repository
        HouseholdRepository repo = Mockito.mock(HouseholdRepository.class);
        HouseholdService service = new HouseholdService(repo);

        // Create mock data
        Household mockHousehold = new Household(1L, "Test Household", "123 Test Street", Collections.emptyList());
        when(repo.findAll()).thenReturn(List.of(mockHousehold));

        // Call service method
        List<HouseholdDTO> result = service.getAllHouseholds();

        // Assertions
        assertEquals(1, result.size());
        assertEquals("Test Household", result.get(0).name());
        assertEquals("123 Test Street", result.get(0).address());
        assertEquals(0, result.get(0).pets().size()); // Ensure pets list is empty
    }
}
