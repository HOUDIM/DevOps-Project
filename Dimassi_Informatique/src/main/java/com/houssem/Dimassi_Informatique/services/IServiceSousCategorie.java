package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import com.houssem.Dimassi_Informatique.entities.SousCategorie;

public interface IServiceSousCategorie {

	void saveSousCategorie(SousCategorie sousCategorie);
    List<SousCategorie> getAllSousCategories();
    SousCategorie getSousCategorie(int id);
    void supprimerSousCategorie(int id);
}
