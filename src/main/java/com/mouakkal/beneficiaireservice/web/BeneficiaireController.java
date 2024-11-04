package com.mouakkal.beneficiaireservice.web;

import com.mouakkal.beneficiaireservice.entities.Beneficiaire;
import com.mouakkal.beneficiaireservice.services.BeneficiaireService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaires")
public class BeneficiaireController {
    private final BeneficiaireService beneficiaireService;

    public BeneficiaireController(BeneficiaireService beneficiaireService) {
        this.beneficiaireService = beneficiaireService;
    }

    @GetMapping
    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficiaireService.findAll();
    }

    @PostMapping
    public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire beneficiaire) {
        return beneficiaireService.save(beneficiaire);
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiaire(@PathVariable Long id) {
        beneficiaireService.deleteById(id);
    }
}