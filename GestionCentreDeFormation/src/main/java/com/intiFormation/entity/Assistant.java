package com.intiFormation.entity;

import java.util.List;

public class Assistant extends Utilisateur {
	
	private int id;
	private List<Relance> relances;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Relance> getRelances() {
		return relances;
	}
	public void setRelances(List<Relance> relances) {
		this.relances = relances;
	}
	
	
	public Assistant() {
		super();
	}
	
	
	
	

}
