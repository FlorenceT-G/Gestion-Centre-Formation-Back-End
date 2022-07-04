package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Formateur extends Utilisateur {
	
	@JsonIgnore
	@OneToMany(mappedBy = "formateur")
	private List<Formation> listeFormations;
	
	
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