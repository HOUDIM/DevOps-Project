package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houssem.Dimassi_Informatique.dao.FactureRepository;
import com.houssem.Dimassi_Informatique.entities.Facture;

@Service
public class ServiceFacture implements IServiceFacture {

	private FactureRepository fr;
	
	public ServiceFacture(FactureRepository fr) {
		super();
		this.fr = fr;
	}

	@Override
	public void saveFacture(Facture facture) {
		// TODO Auto-generated method stub
		fr.save(facture);
	}

	@Override
	public List<Facture> getAllFactures() {
		// TODO Auto-generated method stub
		return fr.findAll();
	}

	@Override
	public Facture getFacture(int id) {
		// TODO Auto-generated method stub
		return fr.findById(id).get();
	}

	@Override
	public void supprimerFacture(int id) {
		// TODO Auto-generated method stub
		fr.deleteById(id);
	}

}
