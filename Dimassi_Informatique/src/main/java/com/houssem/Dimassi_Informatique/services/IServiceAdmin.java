package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import com.houssem.Dimassi_Informatique.entities.Admin;


public interface IServiceAdmin {

	void saveAdmin(Admin admin);
    List<Admin> getAllAdmins();
    Admin getAdmin(int id);
    List<Admin>  getAdminByName(String mc);
    void supprimerAdmin(int id);
}
