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

import com.houssem.Dimassi_Informatique.entities.Photos;
import com.houssem.Dimassi_Informatique.entities.Produit;
import com.houssem.Dimassi_Informatique.services.ServicePhotos;
import com.houssem.Dimassi_Informatique.services.ServiceProduit;
import com.houssem.Dimassi_Informatique.services.ServiceSousCategorie;

@Controller
@RequestMapping("/app/produit")
public class ProduitControlleur {

	ServiceProduit sp;
	ServiceSousCategorie sc;
	ServicePhotos sh;

    public ProduitControlleur(ServiceProduit sp,ServiceSousCategorie sc,ServicePhotos sh) {
        super();
        this.sp = sp;
        this.sc = sc;
        this.sh = sh;
    }

    @GetMapping("/all")
    public String getAllProduits(Model m) {
        List<Produit> liste = sp.getAllProduits();
        m.addAttribute("liste",liste);
        return "Produits";
    }

    @GetMapping("/supprimer/{id}")
    public String suppprimer(@PathVariable int id) throws IOException {
        sp.supprimerProduit(id);
        return "redirect:/app/produit/all";
    }
    
    @GetMapping("/ajouter")
	public String ajouter(Model m) {
    	m.addAttribute("sousCategorie",sc.getAllSousCategories());
		return "Ajouter_Produit";
	}
	
    @PostMapping("/sauvgarder")
	public String sauvgarder(@ModelAttribute Produit p,@ModelAttribute Photos photos,@RequestParam("mainPhoto") MultipartFile mainPhoto,@RequestParam("extraImages") MultipartFile[] extraImages,Model m) throws IOException {
		Integer id =p.getId();
		sh.savePhotos(photos, mainPhoto, extraImages);
		p.setPhotos(photos);
		sp.saveProduit(p);
		
		if(id!=null) {
			return "redirect:/app/produit/all";
		}else {
			m.addAttribute("message","Ajout avec succes");
			m.addAttribute("sousCategorie",sc.getAllSousCategories());
			return "redirect:/app/produit/all";
		}
	}
	
    @GetMapping("/modifier/{id}")
	public String modifier(Model m,@PathVariable("id") int id) {
		m.addAttribute("sousCategorie",sc.getAllSousCategories());
		m.addAttribute("produit",sp.getProduit(id));
		return "Ajouter_Produit";
	}
    
    @GetMapping("/produitVue/{id}")
    public String getProduit(@PathVariable int  id,Model m) throws IOException{
          m.addAttribute("produit",sp.getProduit(id));
          return "ProduitVue";
    }
		
    @GetMapping("/produitmc")
	public String getProduitPMC(@RequestParam String mc,Model m) {
		List<Produit> liste = sp.getProduitByName(mc);
		return "Produits";
	}
    
	}

    




