package com.intiFormation.entity;

import java.util.List;

public class Commercial extends Utilisateur {
	
	private int id;
	private List<Contact> contacts;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
		
		
	}
	public Commercial() {
		super();
	}
	
	
	
	

}
