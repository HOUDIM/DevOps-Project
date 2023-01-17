package com.houssem.Dimassi_Informatique.controlleurs;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.houssem.Dimassi_Informatique.entities.Adresse;

import com.houssem.Dimassi_Informatique.services.ServiceAdresse;


@Controller
@RequestMapping("/app/adresse")
public class AdresseControlleur {

	ServiceAdresse sa;

    public AdresseControlleur(ServiceAdresse sa) {
        super();
        this.sa = sa;
    }

    @GetMapping("/all")
    public String getAddress(Model m) {
        List<Adresse> liste = sa.getAllAdresses();
        m.addAttribute("liste",liste);
        return "Adresses";
    }
}
