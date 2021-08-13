package com.example.TPEtudiant.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TPEtudiant.entity.Classe;
import com.example.TPEtudiant.entity.Professeur;
import com.example.TPEtudiant.repository.ClasseRepository;
import com.example.TPEtudiant.repository.ProfesseurRepository;

@Controller

public class MenuController {
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private ProfesseurRepository professeurRepository;
	@GetMapping("")
	public String getMenu(Map<String, Object> model) {

		return "menu";
	}
	@GetMapping("/menuMoyennes")
	public String getMenuMoyennes(Map<String, Object> model) {
	 	Iterable<Classe> classes = classeRepository.findAll();
	 	model.put("afficherMoyen", classes);
		return "menuMoyennes";
	}
	@GetMapping("/menuClasse")
	public String getMenuClasse(Map<String, Object> model) {
		
		return "menuClasse";
	}
	
	@GetMapping("/menuEtudiant")
	public String getMenuEtudiant(Map<String, Object> model) {
		
		return "menuEtudiant";
	}
	@GetMapping("/menuDetailEtudiant")
	public String getMenuDetailEtudiant(Map<String, Object> model) {
		
		return "menuDetailEtudiant";
	}
	@GetMapping("/menuProf")
	public String getMenuProf(Map<String, Object> model) {
		Iterable<Professeur> profs = professeurRepository.findAll();
		model.put("afficherProf", profs);
		return "menuProf";
	}
	@GetMapping("/Quitter")
	public String getQuitter(Map<String, Object> model) {
		
		return "Quitter";
	}

}

