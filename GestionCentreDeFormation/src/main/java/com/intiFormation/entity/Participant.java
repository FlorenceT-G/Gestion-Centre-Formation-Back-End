package com.intiFormation.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Participant extends Utilisateur {


	@JsonIgnore
	@ManyToMany(mappedBy="listeParticipants")
	private List<Formation> listeFormations;
	
	@OneToMany(mappedBy = "participant")
	private List<Relance> relances;
	
	
	@OneToMany(mappedBy = "participant")
	@JsonIgnore
	private List<Paiement> paiements;
	
	@OneToMany (mappedBy = "participant")
	private List<Score> scores;

	
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
	
	
	
	
	
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	public Participant() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Participant [listeFormations=" + listeFormations + "]";
	}
	
	
	

}
