package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return paiementService.selectAll();
	}
	
	@GetMapping("/admin/paiement/{id}")
	public Paiement chercherUnPaiement(@PathVariable("id") int id) {
		return paiementService.selectById(id);
	}
	
	@PostMapping("/admin/paiement")
	public void ajoutPaiement(@RequestBody Paiement p) {
		paiementService.ajouter(p);
	}
	
	@PutMapping("/admin/paiement/{id}")
	public void modificationPaiement(@RequestBody Paiement p, @PathVariable("id") int id) {
		paiementService.ajouter(p);
	}
	
	@DeleteMapping("/admin/paiement/{id}")
	public void supprimerPaiement(@PathVariable("id") int id) {
		paiementService.supprimer(id);
	}
	
}
