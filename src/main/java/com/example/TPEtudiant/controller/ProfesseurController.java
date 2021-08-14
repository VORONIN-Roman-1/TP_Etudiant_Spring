package com.example.TPEtudiant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TPEtudiant.entity.Professeur;
import com.example.TPEtudiant.repository.ProfesseurRepository;

@Component
@RestController
public class ProfesseurController {

	@Autowired
	private ProfesseurRepository professeurRepository;

	@PostMapping(path = "api/professeurs", consumes = "application/json")
	public ResponseEntity<Integer> postProfesseur(@RequestBody Professeur professeur) {
		professeurRepository.save(professeur);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "api/professeurs/init")
	public ResponseEntity<Integer> postProfesseurInit() {
		List<Professeur> list = new ArrayList<>();
		list.add(new Professeur("Langevin", "Roger", "Mathématiques"));
		list.add(new Professeur("Einstein", "Paul", "Géographie"));
		list.add(new Professeur("Chartier", "Albert", "Chimie"));
		professeurRepository.saveAll(list);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "api/professeurs")
	public Iterable<Professeur> getProfesseur() {
		return professeurRepository.findAll();
	}
}
