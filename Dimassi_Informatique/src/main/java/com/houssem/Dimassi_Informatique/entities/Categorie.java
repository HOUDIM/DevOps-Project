package com.houssem.Dimassi_Informatique.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Categorie {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id ;
    private String nom ;
    
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "categorie")
    @JsonIgnore
    private List<SousCategorie>  sousCategorie;
    
    

}
