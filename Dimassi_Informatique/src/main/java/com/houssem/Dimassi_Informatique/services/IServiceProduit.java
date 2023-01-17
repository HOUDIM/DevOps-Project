package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import com.houssem.Dimassi_Informatique.entities.Produit;

public interface IServiceProduit {

	void saveProduit(Produit produit);
    List<Produit> getAllProduits();
    Produit getProduit(int id);
    List<Produit>  getProduitByName(String mc);
    void supprimerProduit(int id);
}


