package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houssem.Dimassi_Informatique.dao.AdresseRepository;
import com.houssem.Dimassi_Informatique.entities.Adresse;

@Service
public class ServiceAdresse implements IServiceAdresse {

	private AdresseRepository ar;
	
	
	
	public ServiceAdresse(AdresseRepository ar) {
		super();
		this.ar = ar;
	}

	@Override
	public void saveAdresse(Adresse adresse) {
		// TODO Auto-generated method stub
		ar.save(adresse);
	}
	
	@Override
	public List<Adresse> getAllAdresses() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public Adresse getAdresse(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	@Override
	public void supprimerAdresse(int id) {
		// TODO Auto-generated method stub
		ar.deleteById(id);
		
	}

}
