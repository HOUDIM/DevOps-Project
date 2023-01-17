package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houssem.Dimassi_Informatique.dao.ProduitRepository;
import com.houssem.Dimassi_Informatique.entities.Produit;


@Service
public class ServiceProduit implements IServiceProduit  {

	private ProduitRepository pr;
	
	public ServiceProduit(ProduitRepository pr) {
		super();
		this.pr = pr;
	}

	@Override
	public void saveProduit(Produit produit) {
		// TODO Auto-generated method stub
		pr.save(produit);
	}

	@Override
	public List<Produit> getAllProduits() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}
	
	
	public List<Produit> getProduitsBySousCategorie(int id) {
		return pr.findAllBySousCategorie_id(id);
	}

	@Override
	public Produit getProduit(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public List<Produit> getProduitByName(String mc) {
		// TODO Auto-generated method stub
		return pr.findByNomContains(mc);
	}

	@Override
	public void supprimerProduit(int id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

}
