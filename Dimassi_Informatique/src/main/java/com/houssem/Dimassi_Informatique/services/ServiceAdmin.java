package com.houssem.Dimassi_Informatique.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.houssem.Dimassi_Informatique.dao.AdminRepository;

import com.houssem.Dimassi_Informatique.entities.Admin;

@Service
public class ServiceAdmin implements IServiceAdmin {
	
private AdminRepository ar;
	
	public ServiceAdmin(AdminRepository ar) {
		super();
		this.ar = ar;
	}

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		ar.save(admin);
	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	@Override
	public List<Admin> getAdminByName(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerAdmin(int id) {
		// TODO Auto-generated method stub
		ar.deleteById(id);
	}

}
