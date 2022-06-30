package com.intiFormation.entity;

import java.util.List;

public class Participant extends Utilisateur{

	private int id;
	private List<Formation> listeFormations;
	private List<Relance> relances;
	private List<Paiement> paiements;
	
	
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
	public List<Relance> getRelances() {
		return relances;
	}
	public void setRelances(List<Relance> relances) {
		this.relances = relances;
	}
	public List<Paiement> getPaiements() {
		return paiements;
	}
	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}
	
	
	public Participant() {
		super();
	}
	
	
	
	
	
}
