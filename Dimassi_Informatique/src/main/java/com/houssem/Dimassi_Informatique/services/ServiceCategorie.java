package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houssem.Dimassi_Informatique.dao.CategorieRepository;
import com.houssem.Dimassi_Informatique.entities.Categorie;

@Service
public class ServiceCategorie implements IServiceCategorie {

	private CategorieRepository cr;
	
	
	public ServiceCategorie(CategorieRepository cr) {
		super();
		this.cr = cr;
	}

	@Override
	public void saveCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		cr.save(categorie);
	}

	@Override
	public List<Categorie> getAllCategories() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Categorie getCategorie(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

	@Override
	public List<Categorie> getCategorieByName(String mc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void supprimerCategorie(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}
	

}
