package com.example.assignment_ChatGPT.IntegrationTests;

import com.example.assignment_ChatGPT.DTOs.HouseholdDTO;
import com.example.assignment_ChatGPT.Services.HouseholdService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HouseholdIntegrationTest {

    @Autowired
    private HouseholdService householdService;

    @Test
    public void testCreateAndRetrieveHousehold() {
        HouseholdDTO newHousehold = new HouseholdDTO(null, "Johnson Family", "456 Elm St", null);

        HouseholdDTO savedHousehold = householdService.createHousehold(newHousehold);

        assertNotNull(savedHousehold.id());

        HouseholdDTO retrievedHousehold = householdService.getHouseholdById(savedHousehold.id());

        assertEquals("Johnson Family", retrievedHousehold.name());
        assertEquals("456 Elm St", retrievedHousehold.address());
    }
}
