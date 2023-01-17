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

import com.houssem.Dimassi_Informatique.entities.Categorie;
import com.houssem.Dimassi_Informatique.entities.Commentaire;
import com.houssem.Dimassi_Informatique.entities.Photos;
import com.houssem.Dimassi_Informatique.entities.Produit;
import com.houssem.Dimassi_Informatique.services.ServiceCommentaire;
import com.houssem.Dimassi_Informatique.services.ServiceProduit;
import com.houssem.Dimassi_Informatique.services.ServiceVisiteur;



@Controller
@RequestMapping("/app/commentaire")
public class CommentaireControlleur {
	
	ServiceCommentaire sc;
	ServiceVisiteur sv;
	ServiceProduit sp;

    public CommentaireControlleur(ServiceCommentaire sc,ServiceVisiteur sv,ServiceProduit sp) {
        super();
        this.sc = sc;
        this.sv = sv;
        this.sp = sp;
    }

    @GetMapping("/all")
    public String getAllCommentaires(Model m) {
        List<Commentaire> liste = sc.getAllCommentaires();
        m.addAttribute("liste",liste);
        return "Commentaires";
    }

    @GetMapping("/supprimer/{id}")
    public String suppprimerCommentaire(@PathVariable int id) throws IOException {
        sc.supprimerCommentaire(id);
        return "redirect:/app/commentaire/all";
    }
    
    @GetMapping("/ajouter")
   	public String ajouter(Model m) {
       	m.addAttribute("visiteur",sv.getAllVisiteurs());
       	m.addAttribute("produit",sp.getAllProduits());
   		return "Ajouter_Commentaire";
   	}
    @PostMapping("/sauvgarder")
	public String sauvgarder(@ModelAttribute Commentaire c,Model m) throws IOException {
		Integer id =c.getId();
		sc.saveCommentaire(c);
		
		if(id!=null) {
			return "redirect:/app/commentaire/all";
		}else {
			m.addAttribute("message","Ajout avec succes");
			return "redirect:/app/commentaire/all";
		}
	}
   	
       @GetMapping("/modifier/{id}")
   	public String modifier(Model m,@PathVariable("id") int id) {
   		m.addAttribute("visiteur",sv.getAllVisiteurs());
   		m.addAttribute("produit",sp.getAllProduits());
   		m.addAttribute("commentaire",sc.getCommentaire(id));
   		return "Ajouter_Commentaire";
   	}
       
      
}
