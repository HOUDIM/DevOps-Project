package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import com.houssem.Dimassi_Informatique.entities.Commentaire;



public interface IServiceCommentaire {
	
	void saveCommentaire(Commentaire commentaire);
    List<Commentaire> getAllCommentaires();
    List<Commentaire> getAllCommentairesByProduit(int id);
    Commentaire getCommentaire(int id);
    void supprimerCommentaire(int id);
	

}
