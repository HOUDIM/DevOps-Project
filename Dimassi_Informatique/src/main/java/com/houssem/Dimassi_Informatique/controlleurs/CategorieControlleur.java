package com.houssem.Dimassi_Informatique.controlleurs;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.houssem.Dimassi_Informatique.entities.Categorie;

import com.houssem.Dimassi_Informatique.services.ServiceCategorie;


@Controller
@RequestMapping("/app/categorie")
public class CategorieControlleur {
	
	ServiceCategorie sc;
	
	 public CategorieControlleur(ServiceCategorie sc) {
	        super();
	        this.sc = sc;
	    }

	 @GetMapping("/all")
	    public String getAllCategories(Model m) {
	        List<Categorie> liste = sc.getAllCategories();
	        m.addAttribute("liste",liste);
	        return "Categories";
	    }
	 
	 @GetMapping("/supprimer/{id}")
	    public String suppprimerCategorie(@PathVariable int id) throws IOException {
	        sc.supprimerCategorie(id);
	        return "redirect:/app/categorie/all";
	    }
	 @GetMapping("/ajouter")
		public String ajouter(Model m) {
	    	
			return "Ajouter_Categorie";
		}
		
	    @PostMapping("/sauvgarder")
		public String sauvgarder(@ModelAttribute Categorie c,Model m) throws IOException {
			Integer id =c.getId();
			sc.saveCategorie(c);
			
			if(id!=null) {
				return "redirect:/app/categorie/all";
			}else {
				m.addAttribute("message","Ajout avec succes");
				return "redirect:/app/categorie/all";
			}
		}
		
	    @GetMapping("/modifier/{id}")
		public String modifier(Model m,@PathVariable("id") int id) {
			m.addAttribute("categorie",sc.getCategorie(id));
			return "Ajouter_Categorie";
		}
			
	 
}

