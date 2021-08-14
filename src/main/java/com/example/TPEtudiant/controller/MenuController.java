package com.example.TPEtudiant.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TPEtudiant.entity.Classe;
import com.example.TPEtudiant.entity.Etudiant;
import com.example.TPEtudiant.entity.Professeur;
import com.example.TPEtudiant.repository.ClasseRepository;
import com.example.TPEtudiant.repository.EtudiantRepository;
import com.example.TPEtudiant.repository.ProfesseurRepository;

@Controller

public class MenuController {
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;

	@GetMapping("")
	public String getMenu(@RequestParam(value = "number", defaultValue = "99") int number, Map<String, Object> model) {
		switch (number) {
		case 1:
			Iterable<Classe> classes = classeRepository.findAll();
			model.put("montreMoyen", true);
			model.put("afficherMoyen", classes);
			return "menu";
		case 2:
			return "redirect:/menuClasse";
		case 3:
			Iterable<Etudiant> etudiants = etudiantRepository.findAll();
			model.put("montreEtudiants", true);
			model.put("afficherEtudiants", etudiants);
			return "menu";
		case 4:
			return "redirect:/menuDetailEtudiant";
		case 5:
			Iterable<Professeur> professeurs = professeurRepository.findAll();
			model.put("montreProfesseurs", true);
			model.put("afficherProfesseurs", professeurs);
			return "menu";
		case 6:
			return "redirect:/Quitter";
		default:
			return "menu";
		}
	}

	@GetMapping("/menuClasse")
	public String getMenuClasse(Map<String, Object> model) {
		Iterable<Classe> classes = classeRepository.findAll();
		model.put("afficherAllClases", classes);
		return "menuClasse";
	}

	@PostMapping("/menuClasse")
	public String afficherDetailClasseConcret(long number, Map<String, Object> model) {
		if (number == 0)
			return "redirect:/";
		Classe classe = classeRepository.findById(number);
		if (classe == null)
			return "redirect:/menuClasse";
		model.put("afficherDetailClasseConcret", classe);
		Iterable<Classe> classes = classeRepository.findAll();
		model.put("afficherAllClases", classes);
		return "menuClasse";
	}

	@GetMapping("/menuDetailEtudiant")
	public String getMenuDetailEtudiant(Map<String, Object> model) {
		Iterable<Etudiant> etudiants = etudiantRepository.findAll();
		model.put("afficherEtudiants", etudiants);
		return "menuDetailEtudiant";
	}

	@PostMapping("/menuDetailEtudiant")
	public String afficherDetailEtudiantConcret(long number, Map<String, Object> model) {
		if (number == 0)
			return "redirect:/";
		Etudiant etudiant = etudiantRepository.findById(number);
		if (etudiant == null)
			return "redirect:/menuDetailEtudiant";
		model.put("montreDetailEtudiantConcret", true);
		model.put("afficherDetailEtudiantConcret", etudiant);
		Iterable<Etudiant> etudiants = etudiantRepository.findAll();
		model.put("afficherEtudiants", etudiants);
		return "menuDetailEtudiant";
	}

	@GetMapping("/Quitter")
	public String getQuitter(Map<String, Object> model) {

		return "Quitter";
	}

}
