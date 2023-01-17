package com.houssem.Dimassi_Informatique.entities;



import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Photos {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	
	@OneToOne(mappedBy = "photos",fetch = FetchType.LAZY)
	@JsonIgnore
	private Produit produit;

	public Photos(Integer id, String photo1) {
		super();
		this.id = id;
		this.photo1 = photo1;
	}

	public Photos(Integer id, String photo1, String photo2) {
		super();
		this.id = id;
		this.photo1 = photo1;
		this.photo2 = photo2;
	}

	public Photos(Integer id, String photo1, String photo2, String photo3) {
		super();
		this.id = id;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
	}
	
	
	
	
	
	

}

