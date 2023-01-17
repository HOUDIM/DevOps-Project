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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.houssem.Dimassi_Informatique.entities.Adresse;
import com.houssem.Dimassi_Informatique.entities.Visiteur;
import com.houssem.Dimassi_Informatique.services.ServiceAdresse;
import com.houssem.Dimassi_Informatique.services.ServiceVisiteur;

@Controller
@RequestMapping("/app/visiteur")
public class VisiteurControlleur {
	
	ServiceVisiteur sv;
	ServiceAdresse sa;

    public VisiteurControlleur(ServiceVisiteur sv,ServiceAdresse sa) {
        super();
        this.sv = sv;
        this.sa = sa;
    }

    @GetMapping("/all")
    public String getAllVisiteurs(Model m) {
        List<Visiteur> liste = sv.getAllVisiteurs();
        m.addAttribute("liste",liste);
        return "Visiteurs";
    }
    
    @GetMapping("/supprimer/{id}")
    public String suppprimerVisiteur(@PathVariable int id) throws IOException {
        sv.supprimerVisiteur(id);
        return "redirect:/app/visiteur/all";
    }

    @GetMapping("/ajouter")
	public String ajouterVisiteur(Model m) {
    	
		return "Ajouter_Visiteur";
	}
	
	@PostMapping("/sauvgarder")
	public String sauvgarder(@ModelAttribute Visiteur visiteur,@ModelAttribute Adresse adresse,@RequestParam("photo1") MultipartFile image,Model m) throws IOException {
		Integer id =visiteur.getId();
		sa.saveAdresse(adresse);
		visiteur.setAdresse(adresse);
		sv.saveVisiteur(visiteur,image);
		if(id!=null) {
			return "redirect:/app/visiteur/all";
		}else {
			return "redirect:/app/visiteur/all";
		}
		
	}
	
	@GetMapping("/modifier/{id}")
	public String modifier(Model m,@PathVariable("id") int id) {
		m.addAttribute("visiteur",sv.getVisiteur(id));
		return "Ajouter_Visiteur";
	}
	
    
}
