package com.intiFormation.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContact;
	private String compteRendu;
	private LocalDate dateContact;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idProspect")
	@JsonIgnore
	private Prospect prospect;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idCommercial")
	@JsonIgnore
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
