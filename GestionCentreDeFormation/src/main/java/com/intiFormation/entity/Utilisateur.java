package com.intiFormation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	private String nom;
	private String prenom;
	private String adresseMail;
	private String username;
	private String password;
	
	@OneToMany
	@JoinColumn(name="idRole")
	private Role role;

	public Utilisateur() {
		super();
	}
	
	public int getId() { return id; }
	public String getNom() { return nom; }
	public String getPrenom() { return prenom; }
	public String getAdresseMail() { return adresseMail; }
	public String getPassword() { return password; }

	public void setId(int id) { this.id = id; }
	public void setNom(String nom) { this.nom = nom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	public void setAdresseMail(String adresseMail) { this.adresseMail = adresseMail; }
	public void setPassword(String password) { this.password = password; }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
