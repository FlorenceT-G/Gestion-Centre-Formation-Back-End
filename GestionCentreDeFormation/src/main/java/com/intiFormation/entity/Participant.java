package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Participant extends Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParticipant;
	
	@ManyToMany(mappedBy="listeParticipants")
	private List<Formation> listeFormations;
	
	@ManyToOne
	@JoinColumn(name="idRelance")
	private List<Relance> relances;
	
	@ManyToOne
	@JoinColumn(name="idPaiement")
	private List<Paiement> paiements;
	
	
	public int getIdParticipant() {
		return idParticipant;
	}
	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
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
