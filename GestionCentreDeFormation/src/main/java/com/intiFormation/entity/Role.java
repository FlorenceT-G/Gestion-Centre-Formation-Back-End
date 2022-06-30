package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Role {

	private int idRole;
	private String libRole;
	private String description;
	private List<Utilisateur> utilisateurs;

	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getLibRole() {
		return libRole;
	}
	public void setLibRole(String libRole) {
		this.libRole = libRole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public Role() {
		super();
	}
	
	
	
}
