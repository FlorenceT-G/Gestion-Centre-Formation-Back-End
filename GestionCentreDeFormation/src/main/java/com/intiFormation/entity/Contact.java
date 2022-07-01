package com.intiFormation.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContact;
	private String compteRendu;
	private LocalDate dateContact;
	
	@OneToMany(mappedBy="contacts")
	private Prospect prospect;
	
	@OneToMany(mappedBy="contacts")
	private Commercial commercial;
	

	

	public int getIdContact() {
		return idContact;



	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getCompteRendu() {
		return compteRendu;
	}
	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}
	public LocalDate getDateContact() {
		return dateContact;
	}
	public void setDateContact(LocalDate dateContact) {
		this.dateContact = dateContact;
	}
	public Prospect getProspect() {
		return prospect;
	}
	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}
	public Commercial getCommercial() {
		return commercial;
	}
	public void setCommercial(Commercial commercial) {
		this.commercial = commercial;
	}
	
	
	public Contact() {
		super();
	}
	
	

}
