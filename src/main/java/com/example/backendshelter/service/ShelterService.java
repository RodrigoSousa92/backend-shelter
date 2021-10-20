package com.example.backendshelter.service;

import com.example.backendshelter.exception.ShelterNotFound;
import com.example.backendshelter.model.Shelter;
import com.example.backendshelter.repository.ShelterRepository;
import org.springframework.stereotype.Service;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;

    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public Shelter save(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    public Shelter findByNameContaining(String name) {
        return shelterRepository.findByNameContaining(name).orElseThrow(ShelterNotFound::new);
    }

    public Shelter findById(Long id) {
        return shelterRepository.findById(id).orElseThrow(ShelterNotFound::new);
    }

    public void deleteById(Long id) {
        shelterRepository.deleteById(id);
    }
}