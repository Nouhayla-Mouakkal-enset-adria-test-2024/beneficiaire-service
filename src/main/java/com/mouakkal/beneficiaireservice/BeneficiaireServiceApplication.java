package com.mouakkal.beneficiaireservice;

import com.mouakkal.beneficiaireservice.entities.Beneficiaire;
import com.mouakkal.beneficiaireservice.enums.Type;
import com.mouakkal.beneficiaireservice.services.BeneficiaireService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeneficiaireServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeneficiaireServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BeneficiaireService beneficiaireService) {
        return args -> {
            // Création de 10 bénéficiaires de test de façon dynamique
            for (int i = 1; i <= 10; i++) {
                Beneficiaire beneficiaire = new Beneficiaire();
                beneficiaire.setNom("Nom" + i);
                beneficiaire.setPrenom("Prenom" + i);
                beneficiaire.setRib(761234567890L + i); // Génération d'un RIB unique
                beneficiaire.setType(i % 2 == 0 ? Type.PHYSIQUE : Type.MORALE); // Alternance entre Physique et Morale
                beneficiaireService.save(beneficiaire);
            }

            // Affichage des bénéficiaires ajoutés
            beneficiaireService.findAll().forEach(System.out::println);
        };
    }
}
