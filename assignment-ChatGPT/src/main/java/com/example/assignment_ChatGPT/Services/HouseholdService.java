package com.example.assignment_ChatGPT.Services;

import com.example.assignment_ChatGPT.Entities.Household;
import com.example.assignment_ChatGPT.Repositories.HouseholdRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HouseholdService {
    private final HouseholdRepository householdRepository;

    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    public Household createHousehold(Household household) {
        return householdRepository.save(household);
    }

    public Household updateHousehold(Long id, Household household) {
        Household existingHousehold = householdRepository.findById(id).orElseThrow();
        existingHousehold.setName(household.getName());
        return householdRepository.save(existingHousehold);
    }

    public void deleteHousehold(Long id) {
        householdRepository.deleteById(id);
    }
}
