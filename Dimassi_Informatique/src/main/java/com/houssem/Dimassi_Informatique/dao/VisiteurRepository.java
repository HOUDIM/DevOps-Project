package com.houssem.Dimassi_Informatique.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.houssem.Dimassi_Informatique.entities.Visiteur;


public interface VisiteurRepository  extends JpaRepository<Visiteur,Integer> {
	Visiteur findByEmailAndPassword(String email, String password);
}
