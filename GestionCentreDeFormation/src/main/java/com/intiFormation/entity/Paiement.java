package com.intiFormation.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Paiement {

	private int idPaiement;
	private LocalDate datePaiement;
	private int montant;
	private int reste;
	private Participant participant;
	
	
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
