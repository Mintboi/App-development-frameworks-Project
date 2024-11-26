package com.example.assignment_ChatGPT.Repositories;

import com.example.assignment_ChatGPT.Entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {}
