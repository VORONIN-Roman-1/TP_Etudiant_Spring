package com.example.TPEtudiant.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.TPEtudiant.entity.Professeur;

public interface ProfesseurRepository extends CrudRepository<Professeur, Long>  {
	
	Professeur findById(long id);

}
