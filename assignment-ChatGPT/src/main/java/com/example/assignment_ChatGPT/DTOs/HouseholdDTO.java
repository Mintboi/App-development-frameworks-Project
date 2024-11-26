package com.example.assignment_ChatGPT.DTOs;

import java.util.List;

public record HouseholdDTO(Long id, String name, List<PetDTO> pets) {}
