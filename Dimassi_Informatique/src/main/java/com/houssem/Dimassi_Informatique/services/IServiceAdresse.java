package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import com.houssem.Dimassi_Informatique.entities.Adresse;

public interface IServiceAdresse {

	  void saveAdresse(Adresse adresse);
	    Adresse getAdresse(int id);
	    void supprimerAdresse(int id);
	    List<Adresse> getAllAdresses();
}
