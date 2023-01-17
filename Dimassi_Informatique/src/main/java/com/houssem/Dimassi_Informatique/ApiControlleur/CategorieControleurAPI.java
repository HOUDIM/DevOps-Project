package com.houssem.Dimassi_Informatique.ApiControlleur;

import java.io.IOException;
import java.util.List;


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
import com.houssem.Dimassi_Informatique.entities.Categorie;

import com.houssem.Dimassi_Informatique.services.ServiceCategorie;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/categorie")
public class CategorieControleurAPI {

	ServiceCategorie sc;

	public CategorieControleurAPI(ServiceCategorie sc) {
		super();
		this.sc = sc;
	}
	
	
	@GetMapping("/all")
	public List<Categorie> getAllCategories(){
		return  sc.getAllCategories();
	}
	
	
	@GetMapping("/one/{id}")
	public Categorie getCategorie(@PathVariable int  id){
		return  sc.getCategorie(id);
	}
		
	@PostMapping("/ajouter")
	public void saveCategorie(@RequestParam("categorie") String p) throws IOException {
		Categorie pp = new ObjectMapper().readValue(p,Categorie.class);
		sc.saveCategorie(pp);
		
		
	}
	
	@DeleteMapping("supprimer/{id}")
	public void supprimerCategorie(@PathVariable int id) throws IOException{
			sc.supprimerCategorie(id);
	}
	
	@PutMapping("modifier")
	public void modifierCategorie( @RequestParam("categorie") String p ) throws IOException {
		Categorie pp = new ObjectMapper().readValue(p,Categorie.class);
		sc.saveCategorie(pp);
	}
	
}
