package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houssem.Dimassi_Informatique.dao.SousCategorieRepository;
import com.houssem.Dimassi_Informatique.entities.SousCategorie;

@Service
public class ServiceSousCategorie implements IServiceSousCategorie {

	private SousCategorieRepository sr;
	
	public ServiceSousCategorie(SousCategorieRepository sr) {
		super();
		this.sr = sr;
	}

	@Override
	public void saveSousCategorie(SousCategorie sousCategorie) {
		// TODO Auto-generated method stub
		sr.save(sousCategorie);
	}

	@Override
	public List<SousCategorie> getAllSousCategories() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public SousCategorie getSousCategorie(int id) {
		// TODO Auto-generated method stub
		return sr.findById(id).get();
	}

	@Override
	public void supprimerSousCategorie(int id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
	}

}
