package com.houssem.Dimassi_Informatique.entities;

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
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@ToString

public class SousCategorie {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id ;
    private String nom ;
    @ManyToMany(mappedBy = "sousCategorie")
    @JsonIgnore
    private List<Produit> produit;
    
    @ManyToOne()
    private Categorie categorie;
}
