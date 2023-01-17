package com.houssem.Dimassi_Informatique.ApiControlleur;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.houssem.Dimassi_Informatique.entities.Adresse;

import com.houssem.Dimassi_Informatique.entities.Visiteur;
import com.houssem.Dimassi_Informatique.services.ServiceAdresse;
import com.houssem.Dimassi_Informatique.services.ServiceVisiteur;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/visiteur")
public class VisiteurControleurAPI {
	
	ServiceVisiteur sv;
	ServiceAdresse sa;

	public VisiteurControleurAPI(ServiceVisiteur sv,ServiceAdresse sa) {
		super();
		this.sv = sv;
		this.sa=sa;
	}
	
	@GetMapping("/all")
	public List<Visiteur> getAllVisiteurs(){
		return  sv.getAllVisiteurs();
	}
	
	@GetMapping("/one/{id}")
	public Visiteur getVisiteur(@PathVariable int  id){
		return  sv.getVisiteur(id);
	}
	
	@GetMapping("/adresse/{id}")
	public Adresse getAdresse(@PathVariable int  id){
		return  sa.getAdresse(sv.getVisiteur(id).getAdresse().getId());
	}
	
	@GetMapping(path ="/getImage/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable int  id) throws IOException
	{
		return sv.getImage(id);
	}
	
	@PostMapping("/ajouter")
	public void saveVisiteur(@RequestParam("visiteur") String p,@RequestParam("adresse") String a,@RequestParam("photo") MultipartFile photo) throws IOException {
		Adresse aa = new ObjectMapper().readValue(a,Adresse.class);
		Visiteur pp = new ObjectMapper().readValue(p,Visiteur.class);
		sa.saveAdresse(aa);
		pp.setAdresse(aa);
		sv.saveVisiteur(pp,photo);
	}
	
	@PostMapping("/connecter")
	public Visiteur login(@RequestParam("email") String email,@RequestParam("password") String password) throws IOException {
		return sv.connecter(email, password);
	}
	
	@DeleteMapping("supprimer/{id}")
	public void deleteProduct(@PathVariable int id) throws IOException{
			sv.supprimerVisiteur(id);
	}
	
	@PutMapping("/modifier")
	public void modofier(@RequestParam("visiteur") String p,@RequestParam("adresse") String a,@RequestParam("photo") MultipartFile photo ) throws IOException {
		Adresse aa = new ObjectMapper().readValue(a,Adresse.class);
		Visiteur pp = new ObjectMapper().readValue(p,Visiteur.class);
		sa.saveAdresse(aa);
		if(aa.getId()!=null) {
			pp.setAdresse(aa);			
		}
		sv.saveVisiteur(pp,photo);
	}

}
