package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Prospect {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProspect;
	private String nom;
	private String prenom;
	private String email;
	private long numTel;
	
	@OneToMany(mappedBy = "prospect")
	private List<Contact> contacts; 
	
	public int getIdProspect() {
		return idProspect;
	}
	public void setIdProspect(int idProspect) {
		this.idProspect = idProspect;
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
	
	@Override
	public String toString() {
		return "Prospect [idProspect=" + idProspect + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", numTel=" + numTel + "]";
	}


}
