package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Contact;

public interface IContactService {

	
	
	public void ajouter(Contact c);
	
	public void supprimer(int id);
	
	public void modifier(Contact c);
	
	public List<Contact> getAll();
	
	public Optional<Contact> getById(int id);
	
	
}
