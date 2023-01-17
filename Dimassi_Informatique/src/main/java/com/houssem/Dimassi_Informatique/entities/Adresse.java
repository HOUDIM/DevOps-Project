package com.houssem.Dimassi_Informatique.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Adresse {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String rue ;
	private String ville;
	private int numero;
	private int codePostal;
	
	@OneToOne(mappedBy = "adresse")
	@JsonIgnore
	private Visiteur visiteur;
}
