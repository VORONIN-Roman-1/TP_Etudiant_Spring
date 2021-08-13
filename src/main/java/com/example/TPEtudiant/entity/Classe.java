package com.example.TPEtudiant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@JsonIgnore
	private Long id;
	@NotEmpty
	private String nom;
	@NotEmpty
	@OneToOne (optional=false, cascade={CascadeType.MERGE, CascadeType.PERSIST})
	private Professeur professeurPrincipal;
	@NotEmpty
	@OneToMany (fetch = FetchType.EAGER, cascade={CascadeType.MERGE, CascadeType.PERSIST})
	private List<Etudiant> etudiants;

	public Classe() {
	}
	
	public Classe(@NotEmpty String nom, @NotEmpty Professeur professeurPrincipal, @NotEmpty List<Etudiant> etudiants) {
		this.nom = nom;
		this.professeurPrincipal = professeurPrincipal;
		this.etudiants = etudiants;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Professeur getProfesseurPrincipal() {
		return professeurPrincipal;
	}

	public void setProfesseurPrincipal(Professeur professeurPrincipal) {
		this.professeurPrincipal = professeurPrincipal;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	/*
	 * public Classe(String nom, Professeur professeurPrincipal, Etudiant[]
	 * etudiants) { this.nom = nom; this.professeurPrincipal = professeurPrincipal;
	 * this.etudiants = etudiants; }
	 */
	public float plusBasseMoyenne() {
		float moyenneMin = etudiants.get(0).moyenne();
		for (Etudiant etudiant : etudiants) {
			moyenneMin = moyenneMin < etudiant.moyenne() ? moyenneMin : etudiant.moyenne();
		}
		return moyenneMin;
	}

	public float plusHauteMoyenne() {
		float moyenneMax = etudiants.get(0).moyenne();
		for (Etudiant etudiant : etudiants) {
			moyenneMax = moyenneMax > etudiant.moyenne() ? moyenneMax : etudiant.moyenne();
		}
		return moyenneMax;
	}

	public float moyenneClasse() {
		float moyenneAverage = 0f;
		for (Etudiant etudiant : etudiants) {
			moyenneAverage += etudiant.moyenne();
		}
		return moyenneAverage / etudiants.size();
	}

	public String getAffichageMoyen() {
		return "Class : " + nom + " ; la moyenne la plus basse : " + plusBasseMoyenne()
				+ " ; la moyenne de la classe : " + moyenneClasse() + " ; la moyenne la plus haute : "
				+ plusHauteMoyenne();
	}

	public String[] tableauEtudiants() {
		String[] etuds = new String[5];
		for (int i = 0; i < 5; i++)
			etuds[i] = etudiants.get(i).nomPrenom();
		return etuds;
	}

	/*public String affichage() {
		String result = "Class : " + nom + " ; Professeur : " + professeurPrincipal.affichage() + " ; Etudiant : ";
		for (Etudiant etudiant : etudiants) {
			result += " ; " + etudiant.affichage();
		}
		return result;
	}
	*/
}
