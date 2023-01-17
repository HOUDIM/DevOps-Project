package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houssem.Dimassi_Informatique.dao.CommentaireRepository;
import com.houssem.Dimassi_Informatique.entities.Commentaire;


@Service
public class ServiceCommentaire implements IServiceCommentaire  {

	private CommentaireRepository cr;
	
	public ServiceCommentaire(CommentaireRepository cr) {
		super();
		this.cr = cr;
	}

	@Override
	public void saveCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		cr.save(commentaire);
	}

	@Override
	public List<Commentaire> getAllCommentaires() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public Commentaire getCommentaire(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id).get();
	}

	@Override
	public void supprimerCommentaire(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}

	@Override
	public List<Commentaire> getAllCommentairesByProduit(int id) {
		// TODO Auto-generated method stub
		return cr.findAllByProduit_id(id);
	}
}
