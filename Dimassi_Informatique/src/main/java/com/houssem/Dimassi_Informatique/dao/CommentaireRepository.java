package com.houssem.Dimassi_Informatique.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.houssem.Dimassi_Informatique.entities.Commentaire;


public interface CommentaireRepository extends JpaRepository<Commentaire,Integer>{
	List<Commentaire> findAllByProduit_id(Integer id);
}
