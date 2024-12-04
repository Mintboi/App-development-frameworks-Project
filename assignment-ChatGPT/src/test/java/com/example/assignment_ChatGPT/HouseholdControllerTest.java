package com.example.assignment_ChatGPT.Controllers;

import com.example.assignment_ChatGPT.DTOs.HouseholdDTO;
import com.example.assignment_ChatGPT.Services.HouseholdService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class HouseholdControllerTest {

    @Test
    public void testGetAllHouseholds() throws Exception {
        HouseholdService householdService = Mockito.mock(HouseholdService.class);
        HouseholdController controller = new HouseholdController(householdService);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        HouseholdDTO householdDTO = new HouseholdDTO(1L, "Smith Family", "123 Main St", Collections.emptyList());
        when(householdService.getAllHouseholds()).thenReturn(List.of(householdDTO));

        mockMvc.perform(get("/api/households")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Smith Family"));
    }

    // Additional tests can be added here
}
