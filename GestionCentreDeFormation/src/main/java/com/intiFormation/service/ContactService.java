package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IContactDao;
import com.intiFormation.entity.Contact;

@Service
public class ContactService implements IContactService {
	
	
	@Autowired
	IContactDao contactDao;
	
	
	
	public void ajouter(Contact c) {
		
		contactDao.save(c);
		
	}
	
	public void supprimer(int id) {
		
		contactDao.deleteById(id);
	}
	
	
	public void modifier(Contact c) {
		
		contactDao.save(c);
	}
	
	
	public List<Contact> getAll(){
		
		return contactDao.findAll();
		
	}
	
	
	public Optional<Contact> getById(int id){
		
		return contactDao.findById(id);
	}
	
	

}
