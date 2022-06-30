package com.intiFormation.entity;

import java.util.List;

public class Prospect {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private long numTel;
	private List<Contact> contacts; 
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumTel() {
		return numTel;
	}
	public void setNumTel(long numTel) {
		this.numTel = numTel;
	}
	
	
	
	
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	public Prospect() {
		super();
	}
	
	

}
