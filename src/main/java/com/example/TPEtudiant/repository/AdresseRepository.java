package com.example.TPEtudiant.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.TPEtudiant.entity.Adresse;

public interface AdresseRepository extends CrudRepository<Adresse, Long> {
	
	Adresse findById(long id);
}
