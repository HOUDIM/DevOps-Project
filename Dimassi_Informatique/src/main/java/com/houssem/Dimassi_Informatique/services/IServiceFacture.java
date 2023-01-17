package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import com.houssem.Dimassi_Informatique.entities.Facture;

public interface IServiceFacture {

	void saveFacture(Facture facture);
    List<Facture> getAllFactures();
    Facture getFacture(int id);
    void supprimerFacture(int id);
}
