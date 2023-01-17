package com.houssem.Dimassi_Informatique.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.houssem.Dimassi_Informatique.entities.Produit;


public interface ProduitRepository extends JpaRepository<Produit,Integer>{

	List<Produit> findByNomContains(String mc);
	List<Produit> findAllBySousCategorie_id( Integer id);	

}
