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
public class Formateur extends Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormateur;
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