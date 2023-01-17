package com.houssem.Dimassi_Informatique.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.houssem.Dimassi_Informatique.entities.Visiteur;


public interface IServiceVisiteur {

	void saveVisiteur(Visiteur visiteur,MultipartFile photo) throws IOException;
    List<Visiteur> getAllVisiteurs();
    Visiteur getVisiteur(int id);
    Visiteur connecter(String email, String password);
    List<Visiteur>  getVisiteurByName(String mc);
    void supprimerVisiteur(int id);
    void supprimerImage(Integer idVisitor) throws IOException;
    String saveImage(MultipartFile photo)throws IOException ;
    public byte[] getImage(int id) throws IOException;
}
