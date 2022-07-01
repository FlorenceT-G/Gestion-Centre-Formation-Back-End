package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurService {
	
	public void nouvelUtilisateur(Utilisateur u);
	public void modifierUtilisateur(Utilisateur u);
	public void supprimerUtilisateur(int id);
	
	public Optional<Utilisateur> chercherParUsername(String username);
	public List<Utilisateur> tousUtilisateurs();
	public List<Utilisateur> chercherParRole(int idRole);
}
