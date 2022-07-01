package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Assistant extends Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAssistant;
	@OneToMany(mappedBy = "assistant")
	private List<Relance> relances;
	
	
	

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
