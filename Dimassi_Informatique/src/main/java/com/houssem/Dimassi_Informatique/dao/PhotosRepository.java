package com.houssem.Dimassi_Informatique.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.houssem.Dimassi_Informatique.entities.Photos;

public interface PhotosRepository extends JpaRepository<Photos,Integer>{
	Photos findByProduit_id(Integer id);
}
