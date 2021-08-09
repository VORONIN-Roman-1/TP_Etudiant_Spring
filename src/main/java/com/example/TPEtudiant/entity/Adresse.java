package com.example.TPEtudiant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Integer numeroVoie;
	private String typeVoie;
	private String nomVoie;
	private String codePostale;
	private String ville;
	public Adresse() {
	}
	public Adresse(Long id, Integer numeroVoie, String typeVoie, String nomVoie, String codePostale, String ville) {
		this.id = id;
		this.numeroVoie = numeroVoie;
		this.typeVoie = typeVoie;
		this.nomVoie = nomVoie;
		this.codePostale = codePostale;
		this.ville = ville;
	}
	public String getAdressePostale() {
		return numeroVoie + " " + typeVoie + " " + nomVoie + " " + codePostale + " " + ville;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumeroVoie() {
		return numeroVoie;
	}
	public void setNumeroVoie(Integer numeroVoie) {
		this.numeroVoie = numeroVoie;
	}
	public String getTypeVoie() {
		return typeVoie;
	}
	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}
	public String getNomVoie() {
		return nomVoie;
	}
	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	

}
