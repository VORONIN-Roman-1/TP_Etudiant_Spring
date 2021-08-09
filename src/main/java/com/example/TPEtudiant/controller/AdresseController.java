package com.example.TPEtudiant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TPEtudiant.entity.Adresse;
import com.example.TPEtudiant.repository.AdresseRepository;

@Component
@RestController
public class AdresseController {

	@Autowired
    private AdresseRepository adresseRepository;
	
	@PostMapping(path = "api/adresse", consumes = "application/json")
    public String postAdresse(@RequestBody Adresse adresse) {

        return "adresse YES";
    }
}
