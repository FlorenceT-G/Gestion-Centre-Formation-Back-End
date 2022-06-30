package com.intiFormation.entity;

public class Relance {
	
	private int id;
	private Participant participant;
	private Assistant assistant;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Participant getParticipant() {
		return participant;
	}
	public void setParticipant(Participant participant) {
		this.participant = participant;
	}
	public Assistant getAssistant() {
		return assistant;
	}
	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}
	
	
	public Relance() {
		super();
	}
	
	

}
