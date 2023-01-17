package com.houssem.Dimassi_Informatique.entities;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@javax.persistence.Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Commentaire {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	private Date date ;
	private String texte;
	
	@ManyToOne()
	private Visiteur visiteur;
	
	@ManyToOne()
	private Produit produit;

}
