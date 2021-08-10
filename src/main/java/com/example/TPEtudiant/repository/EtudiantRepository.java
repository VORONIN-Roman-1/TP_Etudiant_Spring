package com.example.TPEtudiant.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.TPEtudiant.entity.Etudiant;


public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {

	Etudiant findById(long id);

}
