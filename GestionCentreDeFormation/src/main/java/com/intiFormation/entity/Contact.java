package com.intiFormation.entity;

import java.time.LocalDate;

public class Contact {
	
	private int id;
	private String compteRendu;
	private LocalDate dateContact;
	
	private Prospect prospect;
	private Commercial commercial;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
