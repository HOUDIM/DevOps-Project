package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import com.houssem.Dimassi_Informatique.entities.Categorie;

public interface IServiceCategorie {

	  void saveCategorie(Categorie categorie);
	    List<Categorie> getAllCategories();
	    Categorie getCategorie(int id);
	    List<Categorie>  getCategorieByName(String mc);
	    void supprimerCategorie(int id);
}
