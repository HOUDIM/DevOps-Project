package com.houssem.Dimassi_Informatique.entities;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nom ;
	private double prix;
	private int quantite;
	private String description;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Photos photos;
	
	@ManyToMany()
	
	@JoinTable(name="Produit_SousCategorie",joinColumns = @JoinColumn(name="id_pro"),inverseJoinColumns = @JoinColumn(name="id_sous"))
	private List<SousCategorie> sousCategorie;
	
	@ManyToMany()
	@JsonIgnore
	@JoinTable(name="Produit_facture",joinColumns = @JoinColumn(name="id_pro"),inverseJoinColumns = @JoinColumn(name="id_fac"))
	private List<Facture> factures;
}
