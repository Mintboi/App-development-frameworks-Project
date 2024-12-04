package com.example.assignment_ChatGPT.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private int age;

    @ManyToOne
    @JoinColumn(name = "household_id") // Specify the foreign key column name
    private Household household;
}
