package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commercial extends Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommercial;
	@OneToMany(mappedBy = "commercial")
	private List<Contact> contacts;
	
	public Commercial() {
		super();
	}

	public List<Contact> getContacts() { return contacts; }

	public void setContacts(List<Contact> contacts) { this.contacts = contacts;	}

}
