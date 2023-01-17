package com.houssem.Dimassi_Informatique.ApiControlleur;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
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

import com.houssem.Dimassi_Informatique.entities.SousCategorie;
import com.houssem.Dimassi_Informatique.services.ServiceSousCategorie;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/sousCategorie")
public class SousCategorieControleurAPI {


		ServiceSousCategorie ss;

		public SousCategorieControleurAPI(ServiceSousCategorie ss) {
			super();
			this.ss = ss;
		}
		
		
		@GetMapping("/all")
        public List<SousCategorie> getAllSousCategories(){
			return  ss.getAllSousCategories();
		}
		
	   
		
		
		@GetMapping("/one/{id}")
		public SousCategorie getSousCategorie(@PathVariable int  id){
			return  ss.getSousCategorie(id);
		}
			
		@PostMapping("/ajouter")
		public void saveSousCategorie(@RequestParam("sousCategorie") String p) throws IOException {
			SousCategorie pp = new ObjectMapper().readValue(p,SousCategorie.class);
			ss.saveSousCategorie(pp);
			
			
		}
		
		@DeleteMapping("supprimer/{id}")
		public void supprimerSousCategorie(@PathVariable int id) throws IOException{
				ss.supprimerSousCategorie(id);
		}
		
		@PutMapping("modifier")
		public void modifierSousCategorie( @RequestParam("sousCategorie") String p ) throws IOException {
			SousCategorie pp = new ObjectMapper().readValue(p,SousCategorie.class);
			ss.saveSousCategorie(pp);
		}

}
