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
	private int idRole;
	
	@OneToMany
	@JoinColumn(name="idParticipant")
	private Participant participant;
	
	@OneToMany
	@JoinColumn(name="idAssistant")
	private Assistant assistant;
	
	public Relance() {
		super();
	}
	
	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public Participant getParticipant() { return participant; }
	public Assistant getAssistant() { return assistant; }

	public void setParticipant(Participant participant) { this.participant = participant; }
	public void setAssistant(Assistant assistant) { this.assistant = assistant; }
	
}
