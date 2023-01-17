package com.houssem.Dimassi_Informatique.entities;



import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Admin extends Utilisateur{

	private String test;
}
