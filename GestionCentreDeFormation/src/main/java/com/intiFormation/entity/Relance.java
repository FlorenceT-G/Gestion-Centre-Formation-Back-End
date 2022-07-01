package com.intiFormation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Relance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRelance;
	
	@OneToMany(mappedBy="relances")
	private Participant participant;
	
	@OneToMany(mappedBy="relances")
	private Assistant assistant;
	
	
	public Relance() {
		super();
	}
	
	

	public int getIdRelance() {
		return idRelance;
	}



	public void setIdRelance(int idRelance) {
		this.idRelance = idRelance;
	}



	public Participant getParticipant() { return participant; }
	public Assistant getAssistant() { return assistant; }

	public void setParticipant(Participant participant) { this.participant = participant; }
	public void setAssistant(Assistant assistant) { this.assistant = assistant; }
	
}
