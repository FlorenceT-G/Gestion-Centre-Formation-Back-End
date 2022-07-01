package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IUtilisateurDao;
import com.intiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService {
	
	@Autowired
	IUtilisateurDao utilisateurDao;

	public void nouvelUtilisateur(Utilisateur u) {
		utilisateurDao.save(u);
	}
	
	public void modifierUtilisateur(Utilisateur u) {
		utilisateurDao.save(u);
	}
	
	public void supprimerUtilisateur(int id) {
		utilisateurDao.deleteById(id);
	}
	
	public Optional<Utilisateur> chercherParUsername(String username) {
		return utilisateurDao.findByUsername(username);
	}
	
	public List<Utilisateur> tousUtilisateurs() {
		return utilisateurDao.findAll();
	}
	
	public List<Utilisateur> chercherParRole(int idRole) {
		return utilisateurDao.findByRole_idRole(idRole);
	}

}
