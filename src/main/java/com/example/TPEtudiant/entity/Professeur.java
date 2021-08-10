package com.example.TPEtudiant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Professeur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@NotEmpty
	public String nom;
	@NotEmpty
	public String prenom;

	@NotEmpty
	public String matiere;

	public Professeur() {
	}

	public Professeur(String nom, String prenom, String matiere) {
		this.nom = nom;
		this.prenom = prenom;
		this.matiere = matiere;
	}

	public String nomPrenom() {
		return nom + " " + prenom;
	}

	public String affichage() {
		return nomPrenom() + " ; matière : " + matiere;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
}
