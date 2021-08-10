package com.example.TPEtudiant.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping(path = "api/adresses", consumes = "application/json")
	public ResponseEntity<Integer> postAdresse(@RequestBody Adresse adresse) {
		adresseRepository.save(adresse);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "api/adresses/init", consumes = "application/json")
	public ResponseEntity<Integer> postAdresseInit() {
		Adresse[] temp = new Adresse[] { new Adresse(35, "Avenue", "Gloire", "13100", "Aix en Provence"),
				new Adresse(56, "Rue", "Gloire", "13001", "Marseille"),
				new Adresse(22, "Allée", "de Provence", "04100", "Manosque"),
				new Adresse(88, "Rue", "du Grand Saint-Jean", "34000", "Montpellier"),
				new Adresse(11, "Rue", "de la République", "84000", "Avignon") };

		List<Adresse> adresses = Arrays.asList(temp);
		adresseRepository.saveAll(adresses);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "api/adresses")
	public Iterable<Adresse> getAllAdresse() {
		return adresseRepository.findAll();
	}
}
