package com.intiFormation.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Formation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormation;
	private String libFormation;
	private String description;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private int cout;
	
	@ManyToMany
	@JoinTable(name="T_Formation_Participant",
	joinColumns = @JoinColumn(name="idFormation"),
	inverseJoinColumns = @JoinColumn(name="idParticipant"))	
	private List<Participant> listeParticipants;
	
	@ManyToOne 
	@JoinColumn(name = "idFormateur") // Mettre un CascadeType.ALL ou .PERSIST pour affecter formation à formateur
	private Formateur formateur;
	
	@JsonIgnore
	@OneToMany(mappedBy = "formation")
	private List<Paiement> paiements;
	
	
	
	
	public List<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}
	public int getIdFormation() {
		return idFormation;
	}
	public void setIdFormation(int idFormation) {
		this.idFormation = idFormation;
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
