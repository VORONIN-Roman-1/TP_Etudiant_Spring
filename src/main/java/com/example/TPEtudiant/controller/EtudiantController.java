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

import com.example.TPEtudiant.entity.Adresse;
import com.example.TPEtudiant.entity.Etudiant;
import com.example.TPEtudiant.repository.AdresseRepository;
import com.example.TPEtudiant.repository.EtudiantRepository;

@Component
@RestController
public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private AdresseRepository adresseRepository;

	@PostMapping(path = "api/etudiants", consumes = "application/json")
	public ResponseEntity<Integer> postEtudiant(@RequestBody Etudiant etudiant) {
		etudiantRepository.save(etudiant);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "api/etudiants/init", consumes = "application/json")
	public ResponseEntity<Integer> postAdresseInit() {
		Iterable<Adresse> adresses = adresseRepository.findAll();
		Iterator<Adresse> iter = adresses.iterator();
		List<Float> list = new ArrayList<>();
		list.add(1.2f);
		list.add(3.5f);
		list.add(14f);
		list.add(6f);
		Etudiant[] temp = new Etudiant[] { new Etudiant("Audiard", "Jean-Paul", iter.next(), list),
				new Etudiant("Lanoux", "Emmanuelle", iter.next(), Arrays.asList(new Float[] { 7.8f, 9.4f, 4f, 2f })),
				new Etudiant("Belmondo", "Victor", iter.next(), Arrays.asList(new Float[] { 5.0f, 11.3f, 8f, 9f })),
				new Etudiant("Rochefort", "Jacques ", iter.next(), Arrays.asList(new Float[] { 3.2f, 12.8f, 2f, 0f })),
				new Etudiant("Riva", "Alexander", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Kristoff", "Jean", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 12f, 3f })),
				new Etudiant("Rondeaux", "Louis", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 6f })),
				new Etudiant("Perrot", "Claude", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Flickinger", "Alexandre", iter.next(),
						Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Rogers", "Guillaume", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Trousselier", "Octave", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Vinokourov", "Roger", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Lapize", "Andy", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Sagan", "Michael", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })),
				new Etudiant("Chapperon", "Peter", iter.next(), Arrays.asList(new Float[] { 9.2f, 7.3f, 11f, 9f })) };

		List<Etudiant> etudiants = Arrays.asList(temp);
		etudiantRepository.saveAll(etudiants);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "api/etudiants")
	public Iterable<Etudiant> getAllEtudiant() {
		return etudiantRepository.findAll();
	}
}
