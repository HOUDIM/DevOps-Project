package com.houssem.Dimassi_Informatique.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Visiteur extends Utilisateur {
	
	@OneToOne(cascade = CascadeType.ALL)
	private Adresse adresse ;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "visiteur")
	@JsonIgnore
	private List<Commentaire> commentaires;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "visiteur")
	@JsonIgnore
	private List<Facture> factures;

}
