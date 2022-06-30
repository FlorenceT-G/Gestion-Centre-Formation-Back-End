package com.intiFormation.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Relance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Participant participant;
	private Assistant assistant;
	
	public Relance() {
		super();
	}
	
	public int getId() { return id; }
	public Participant getParticipant() { return participant; }
	public Assistant getAssistant() { return assistant; }

	public void setId(int id) { this.id = id; }
	public void setParticipant(Participant participant) { this.participant = participant; }
	public void setAssistant(Assistant assistant) { this.assistant = assistant; }
	
}
