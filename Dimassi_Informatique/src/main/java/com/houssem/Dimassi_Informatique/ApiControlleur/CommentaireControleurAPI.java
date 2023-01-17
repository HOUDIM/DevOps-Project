package com.houssem.Dimassi_Informatique.ApiControlleur;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.houssem.Dimassi_Informatique.entities.Commentaire;

import com.houssem.Dimassi_Informatique.services.ServiceCommentaire;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/commentaire")
public class CommentaireControleurAPI {

	ServiceCommentaire sc;

	public CommentaireControleurAPI(ServiceCommentaire sc) {
		super();
		this.sc = sc;
	}
	
	
	@GetMapping("/all")
	public List<Commentaire> getAllCommentaires(){
		return  sc.getAllCommentaires();
	}
	
	@GetMapping("/allByProduit/{id}")
	public List<Commentaire> getAllCommentaireByPlant(@PathVariable int  id){
		return  sc.getAllCommentairesByProduit(id);
	}
	
	
	@GetMapping("/one/{id}")
	public Commentaire getCommentaire(@PathVariable int  id){
		return  sc.getCommentaire(id);
	}
		
	@PostMapping("/ajouter")
	public void saveCommentaire(@RequestParam("commentaire") String p) throws IOException {
		Commentaire pp = new ObjectMapper().readValue(p,Commentaire.class);
		sc.saveCommentaire(pp);
		
		
	}
	
	@DeleteMapping("supprimer/{id}")
	public void supprimerCommentaire(@PathVariable int id) throws IOException{
			sc.supprimerCommentaire(id);
	}
	
	@PutMapping("modifier")
	public void modifierCommentaire( @RequestParam("commentaire") String p ) throws IOException {
		Commentaire pp = new ObjectMapper().readValue(p,Commentaire.class);
		sc.saveCommentaire(pp);
	}
}
