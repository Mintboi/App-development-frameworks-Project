package com.example.assignment_ChatGPT;

import com.example.assignment_ChatGPT.Controllers.PetController;
import com.example.assignment_ChatGPT.DTOs.PetDTO;
import com.example.assignment_ChatGPT.Services.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class PetControllerTest {

    @Test
    public void testGetAllPets() throws Exception {
        PetService petService = Mockito.mock(PetService.class);
        PetController controller = new PetController(petService);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        PetDTO petDTO = new PetDTO(1L, "Buddy", "Dog", 5, 1L);
        when(petService.getAllPets()).thenReturn(List.of(petDTO));

        mockMvc.perform(get("/api/pets")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Buddy"));
    }

    // Additional tests can be added here
}
