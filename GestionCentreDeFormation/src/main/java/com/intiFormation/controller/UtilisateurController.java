package com.intiFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Utilisateur;
import com.intiFormation.service.IUtilisateurService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http//localhost:4200")
public class UtilisateurController {
	
	@Autowired
	IUtilisateurService uService;
	
	@PostMapping("/utilisateurs")
	public void insert(@RequestBody Utilisateur utilisateur) {
		uService.nouvelUtilisateur(utilisateur);
	}
	
	@PutMapping("/utilisateurs")
	public void modify(@RequestBody Utilisateur utilisateur) {
		uService.modifierUtilisateur(utilisateur);
	}
	
	@DeleteMapping("/utilisateurs/{id}")
	public void delete(@PathVariable("id") int idUtilisateur) {
		uService.supprimerUtilisateur(idUtilisateur);
	}
	
	@GetMapping("/utilisateurs")
	public List<Utilisateur> selectAll() {
		return uService.tousUtilisateurs();
	}
	
	@GetMapping("/utilisateurs/{username}")
	public Optional<Utilisateur> selectByUsername(@PathVariable("username") String username) {
		return uService.chercherParUsername(username);
	}
	
	// public Optional<Utilisateur> chercherParNom(String nom);
	// public List<Utilisateur> chercherParRole(int idRole);
	
	
}