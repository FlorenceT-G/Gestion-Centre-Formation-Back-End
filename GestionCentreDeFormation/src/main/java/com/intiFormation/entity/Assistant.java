package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Assistant extends Utilisateur {
	
	
	@OneToMany(mappedBy = "assistant")
	private List<Relance> relances;
	
	
	
	
	
	public List<Relance> getRelances() {
		return relances;
	}
	public void setRelances(List<Relance> relances) {
		this.relances = relances;
	}
	
	
	public Assistant() {
		super();
	}
	@Override
	public String toString() {
		return "Assistant [getNom()=" + getNom() + ", getPrenom()="
				+ getPrenom() + ", getAdresseMail()=" + getAdresseMail() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + "]";
	}
	
	
	
	
	
	
	
	
	

}
