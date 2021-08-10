package com.example.TPEtudiant.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	@NotEmpty
	public String nom;
	@NotEmpty
	public String prenom;
	@NotEmpty
	@OneToOne (optional=false, cascade=CascadeType.ALL)
    //@JoinColumn
	public Adresse adresse;
	@Size(min = 3)
	@NotEmpty
	@ElementCollection
	List<Float> notes = new ArrayList<>();
	
	public Etudiant() {
	}

	public Etudiant(String nom, String prenom, Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public Etudiant(String nom, String prenom, Adresse adresse, List<Float> notes) {
		this(nom, prenom, adresse);
		this.notes = notes;
	}

	
	public String nomPrenom() {
		return nom + " " + prenom;
	}

	public float moyenne() {
		return (notes.get(0) + notes.get(1) + notes.get(2)) / 3;
	}

//	public String getAdressePostale() {
//		return nomPrenom() + " ; Adresse: " + adresse.getAdressePostale();
//	}
//
//	public String affichage() {
//		return getAdressePostale() + " ; " + "Notes: " + notes.get(0) + " ; " + notes.get(1) + " ; " + notes.get(2)
//				+ " ; moyenne = " + moyenne();
//	}

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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Float> getNotes() {
		return notes;
	}

	public void setNotes(List<Float> notes) {
		this.notes = notes;
	}

}
