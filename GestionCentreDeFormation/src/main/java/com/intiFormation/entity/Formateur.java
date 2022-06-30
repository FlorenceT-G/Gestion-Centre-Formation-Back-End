package com.intiFormation.entity;

import java.util.List;

public class Formateur extends Utilisateur {
	
	private int id;
	private List<Formation> listeFormations;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Formation> getListeFormations() {
		return listeFormations;
	}
	public void setListeFormations(List<Formation> listeFormations) {
		this.listeFormations = listeFormations;
	}
	
	
	
	public Formateur() {
		super();
	}
	
	
	
	
	
	
	

}
