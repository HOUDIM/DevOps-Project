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
import com.houssem.Dimassi_Informatique.entities.Photos;
import com.houssem.Dimassi_Informatique.entities.Produit;
import com.houssem.Dimassi_Informatique.services.ServicePhotos;
import com.houssem.Dimassi_Informatique.services.ServiceProduit;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/produit")
public class ProduitControleurAPI {
	
	ServiceProduit sp;
	ServicePhotos sph;
	
	public ProduitControleurAPI(ServiceProduit sp,ServicePhotos sph) {
		super();
		this.sp = sp;
		this.sph = sph;
	}
	
	@GetMapping("/all")
	public List<Produit> getAllProduits(){
		return  sp.getAllProduits();
	}
	
	@GetMapping("/one/{id}")
	public Produit getProduit(@PathVariable int  id){
		return  sp.getProduit(id);
	}
	
	@GetMapping("/categorie/{id}")
	public List<Produit> getProduitBySousCategorie(@PathVariable int  id){
		return  sp.getProduitsBySousCategorie(id);
	}
	
	@GetMapping(path ="/Image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage(@PathVariable int  id) throws IOException
	{
		return sph.getPhotos(id);
		
	}
	
	@GetMapping(path ="/getImage2/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage2(@PathVariable int  id) throws IOException
	{
		return sph.getPhotos2(sp.getProduit(id).getPhotos().getId());
		
	}
	@GetMapping(path ="/getImage3/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage3(@PathVariable int  id) throws IOException
	{
		return sph.getPhotos3(sp.getProduit(id).getPhotos().getId());
		
	}
	@GetMapping(path ="/getImage4/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImage4(@PathVariable int  id) throws IOException
	{
		return sph.getPhotos4(sp.getProduit(id).getPhotos().getId());
		
	}
	
	@PostMapping("/ajouter")
	public void sauvgarderProduit(@RequestParam("produit") String p,@RequestParam("mainPhoto") MultipartFile mainPhoto,@RequestParam("extraImages") MultipartFile[] extraImages ) throws IOException {
		Produit pp = new ObjectMapper().readValue(p,Produit.class);
		if(mainPhoto!=null){
	   		Photos phs = new Photos();
			sph.savePhotos(phs, mainPhoto, extraImages);
			pp.setPhotos(phs);
	   	}
		sp.saveProduit(pp);
		
		
	}
	
	@DeleteMapping("suppmrimer/{id}")
	public void supprimerProduit(@PathVariable int id) throws IOException{
			sp.supprimerProduit(id);
	}
	@GetMapping("/photo/{id}")
	public Photos getAllPhotos(@PathVariable int  id){
		return  sph.getPhotosByProduit(id);
	}
	
	@PutMapping("modifier")
	public void modofierProduit(@RequestParam("produit") String p,@RequestParam("mainPhoto") MultipartFile mainPhoto,@RequestParam("extraImages") MultipartFile[] extraImages ) throws IOException {
		Produit pp = new ObjectMapper().readValue(p,Produit.class);
				
	   	if(mainPhoto!=null){
	   		Photos phs = sph.getPhoto(pp.getPhotos().getId());
			sph.savePhotos(phs, mainPhoto, extraImages);
			pp.setPhotos(phs);
	   	}
		sp.saveProduit(pp);
	}

}
