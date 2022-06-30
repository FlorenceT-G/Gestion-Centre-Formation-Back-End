package com.intiFormation.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Formation {
	
	private int id;
	private String libFormation;
	private String description;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int cout;
	private List<Participant> listeParticipants;
	private Formateur formateur;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibFormation() {
		return libFormation;
	}
	public void setLibFormation(String libFormation) {
		this.libFormation = libFormation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	
	
	
	public List<Participant> getListeParticipants() {
		return listeParticipants;
	}
	public void setListeParticipants(List<Participant> listeParticipants) {
		this.listeParticipants = listeParticipants;
	}
	
	
	
	
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Formation() {
		super();
	}
	
	
	

}
