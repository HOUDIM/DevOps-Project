
package com.houssem.Dimassi_Informatique.entities;



import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Utilisateur {

	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String nom ;
	private String prenom;
	private String email;
	private String password;
	private String photo;
}
