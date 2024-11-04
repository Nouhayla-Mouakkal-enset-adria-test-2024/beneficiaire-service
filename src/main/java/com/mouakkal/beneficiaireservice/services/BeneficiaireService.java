package com.mouakkal.beneficiaireservice.services;

import com.mouakkal.beneficiaireservice.entities.Beneficiaire;
import com.mouakkal.beneficiaireservice.repositories.BeneficiaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaireService {
    private final BeneficiaireRepository beneficiaireRepository;

    public BeneficiaireService(BeneficiaireRepository beneficiaireRepository) {
        this.beneficiaireRepository = beneficiaireRepository;
    }

    public List<Beneficiaire> findAll() {
        return beneficiaireRepository.findAll();
    }

    public Beneficiaire save(Beneficiaire beneficiaire) {
        return beneficiaireRepository.save(beneficiaire);
    }

    public void deleteById(Long id) {
        beneficiaireRepository.deleteById(id);
    }
}