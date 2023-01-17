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



import com.houssem.Dimassi_Informatique.entities.SousCategorie;
import com.houssem.Dimassi_Informatique.services.ServiceCategorie;
import com.houssem.Dimassi_Informatique.services.ServiceSousCategorie;

@Controller
@RequestMapping("/app/sousCategorie")
public class SousCategorieControlleur {
	
	ServiceSousCategorie ss;
	ServiceCategorie sc;

	 public SousCategorieControlleur(ServiceSousCategorie ss,ServiceCategorie sc) {
	        super();
	        this.ss = ss;
	        this.sc = sc;
	    }
	 @GetMapping("/all")
	    public String getAllSousCategories(Model m) {
	        List<SousCategorie> liste = ss.getAllSousCategories();
	        m.addAttribute("liste",liste);
	        return "SousCategories";
	    }
	 
	 @GetMapping("/supprimer/{id}")
	    public String suppprimerSousCategorie(@PathVariable int id) throws IOException {
	        ss.supprimerSousCategorie(id);
	        return "redirect:/app/sousCategorie/all";
	    }

	 @GetMapping("/ajouter")
		public String ajouter(Model m) {
	    	m.addAttribute("categorie",sc.getAllCategories());
			return "Ajouter_SousCategorie";
		}
		
	    @PostMapping("/sauvgarder")
		public String sauvgarder(@ModelAttribute SousCategorie s,Model m) throws IOException {
			Integer id =s.getId();
			ss.saveSousCategorie(s);
			
			if(id!=null) {
				return "redirect:/app/sousCategorie/all";
			}else {
				m.addAttribute("message","Ajout avec succes");
				m.addAttribute("categorie",sc.getAllCategories());
				return "redirect:/app/sousCategorie/all";
			}
		}
		
	    @GetMapping("/modifier/{id}")
		public String modifier(Model m,@PathVariable("id") int id) {
			m.addAttribute("categorie",sc.getAllCategories());
			m.addAttribute("sousCategorie",ss.getSousCategorie(id));
			return "Ajouter_SousCategorie";
		}
}

