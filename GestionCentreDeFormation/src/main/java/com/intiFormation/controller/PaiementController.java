package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Paiement;
import com.intiFormation.service.IPaiementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaiementController {

	@Autowired
	IPaiementService paiementService;
	
	@GetMapping("/admin/paiement")
	public List<Paiement> chercherTtPaiement() {
		// return paiementService.selectAll();
		return null;
	}
	
	@GetMapping("/admin/paiement/{id}")
	public Paiement chercherUnPaiement(int id) {
		// return paiementService.selectById(id);
		return null;
	}
	
	@PostMapping("/admin/paiement")
	public void ajoutPaiement(Paiement p) {
		// paiementService.ajouter(p);
	}
	
	@DeleteMapping("/admin/paiement")
	public void supprimerPaiement(int id) {
		// paiementService.supprimer(id);
	}
	
}