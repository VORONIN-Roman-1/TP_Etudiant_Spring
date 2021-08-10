package com.example.TPEtudiant.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.TPEtudiant.entity.Classe;

public interface ClasseRepository extends CrudRepository<Classe, Long>{
	Classe findById(long id);

}
