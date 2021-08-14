package com.example.TPEtudiant.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TPEtudiant.entity.Classe;
import com.example.TPEtudiant.entity.Etudiant;
import com.example.TPEtudiant.entity.Professeur;
import com.example.TPEtudiant.repository.ClasseRepository;
import com.example.TPEtudiant.repository.EtudiantRepository;
import com.example.TPEtudiant.repository.ProfesseurRepository;

@Component
@RestController
public class ClasseController {
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;

	@PostMapping(path = "api/classes", consumes = "application/json")
	public ResponseEntity<Integer> postClasse(@RequestBody Classe classe) {
		classeRepository.save(classe);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "api/classes/init")
	public ResponseEntity<Integer> postClasseInit() {
		Iterable<Etudiant> etudiants = etudiantRepository.findAll();
		Iterable<Professeur> professeurs = professeurRepository.findAll();
		Iterator<Professeur> iterProf = professeurs.iterator();
		Iterator<Etudiant> iterEtud = etudiants.iterator();
		List<Classe> classes = new ArrayList<>();
		classes.add(new Classe("3ème1", iterProf.next(), Arrays.asList(new Etudiant[] { iterEtud.next(),
				iterEtud.next(), iterEtud.next(), iterEtud.next(), iterEtud.next() })));
		classes.add(new Classe("4ème2", iterProf.next(), Arrays.asList(new Etudiant[] { iterEtud.next(),
				iterEtud.next(), iterEtud.next(), iterEtud.next(), iterEtud.next() })));
		classes.add(new Classe("5ème3", iterProf.next(), Arrays.asList(new Etudiant[] { iterEtud.next(),
				iterEtud.next(), iterEtud.next(), iterEtud.next(), iterEtud.next() })));
		classeRepository.saveAll(classes);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "api/classes")
	public Iterable<Classe> getClasse() {
		return classeRepository.findAll();
	}
}
