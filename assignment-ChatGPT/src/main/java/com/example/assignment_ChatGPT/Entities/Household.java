package com.example.assignment_ChatGPT.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Household {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

    // No-args constructor
    public Household() {
    }

    // Constructor without the pets list
    public Household(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
