package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRole;
	private String libRole;
	private String description;
	
	@ManyToMany(mappedBy="role")
	private List<Utilisateur> utilisateurs;
	
	public Role() {
		super();
	}
	
	public int getIdRole() { return idRole; }
	public String getLibRole() { return libRole; }
	public String getDescription() { return description; }
	public List<Utilisateur> getUtilisateurs() { return utilisateurs; }
	
	public void setIdRole(int idRole) { this.idRole = idRole; }
	public void setLibRole(String libRole) { this.libRole = libRole; }
	public void setDescription(String description) { this.description = description; }
	public void setUtilisateurs(List<Utilisateur> utilisateurs) { this.utilisateurs = utilisateurs; }		
	
}
