package com.houssem.Dimassi_Informatique.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Facture {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	private Date dateAchat ;
	
	@ManyToMany(mappedBy = "factures")
	@JsonIgnore
	private List<Produit> produits; 
	@ManyToOne()
	@JsonIgnore
	private Visiteur visiteur;
}
