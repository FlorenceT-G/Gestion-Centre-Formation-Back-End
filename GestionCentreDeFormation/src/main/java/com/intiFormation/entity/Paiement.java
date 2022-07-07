package com.intiFormation.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaiement;
	private LocalDate datePaiement;
	private int montant;
	private int reste;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idParticipant")
	private Participant participant;

	@ManyToOne
	@JoinColumn(name = "idFormation")
	private Formation formation;
	
	
	
	
	

	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public int getIdPaiement() {
		return idPaiement;
	}
	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}
	public LocalDate getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public int getReste() {
		return reste;
	}
	public void setReste(int reste) {
		this.reste = reste;
	}
	
	
	
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	
	
	public Paiement() {
		super();
	}
	
	
	
}
