package com.houssem.Dimassi_Informatique.controlleurs;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houssem.Dimassi_Informatique.entities.Facture;

import com.houssem.Dimassi_Informatique.services.ServiceFacture;


@Controller
@RequestMapping("/app/facture")
public class FactureControlleur {

	ServiceFacture sf;

    public FactureControlleur(ServiceFacture sf) {
        super();
        this.sf = sf;
    }

    @GetMapping("/all")
    public String getAllFactures(Model m) {
        List<Facture> liste = sf.getAllFactures();
        m.addAttribute("liste",liste);
        return "Factures";
    }
	
    @GetMapping("/supprimerFacture/{id}")
    public String suppprimerFacture(@PathVariable int id) throws IOException {
        sf.supprimerFacture(id);
        return "redirect:/app/facture/all";
    }

}
