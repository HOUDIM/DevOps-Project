package com.houssem.Dimassi_Informatique.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.houssem.Dimassi_Informatique.dao.VisiteurRepository;
import com.houssem.Dimassi_Informatique.entities.Visiteur;


@Service
public class ServiceVisiteur implements IServiceVisiteur  {

	VisiteurRepository vr;
	
	public ServiceVisiteur(VisiteurRepository vr) {
		super();
		this.vr = vr;
	}

	@Override
	public void saveVisiteur(Visiteur visiteur , MultipartFile photo) throws IOException {
		// TODO Auto-generated method stub
		if(!photo.getOriginalFilename().equals("")) {
            visiteur.setPhoto(saveImage(photo));
            
        }
		vr.save(visiteur);
	}

	@Override
	public List<Visiteur> getAllVisiteurs() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	@Override
	public Visiteur getVisiteur(int id) {
		// TODO Auto-generated method stub
		return vr.findById(id).get();
	}

	@Override
	public List<Visiteur> getVisiteurByName(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerVisiteur(int id) {
		// TODO Auto-generated method stub
		vr.deleteById(id);
	}
	
	@Override
	public void supprimerImage(Integer idVisiteur) throws IOException {
		// TODO Auto-generated method stub
		Visiteur visiteur = vr.getById(idVisiteur);
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/Images/";
		Path p = Paths.get(chemin,visiteur.getPhoto());
		Files.delete(p);
	}

	@Override
	public String saveImage(MultipartFile photo) throws IOException {
		String nameFile = photo.getOriginalFilename();
		String tab[] =nameFile.split("\\.");
		String fileModif = tab[0]+"_"+System.currentTimeMillis()+"."+tab[1];
		
		String chemin = System.getProperty("user.dir")+"/src/main/webapp/Images/";
		Path p = Paths.get(chemin,fileModif);
		Files.write(p,photo.getBytes());	
		
		return fileModif;
	}

	@Override
	public byte[] getImage(int id) throws IOException {
		// TODO Auto-generated method stub
		String chemin = System.getProperty("user.home")+"/Images";
		Path path = Paths.get(chemin,getVisiteur(id).getPhoto());
		return Files.readAllBytes(path);
	}

	@Override
	public Visiteur connecter(String email, String password) {
		// TODO Auto-generated method stub
		return vr.findByEmailAndPassword(email, password);
	}
}
