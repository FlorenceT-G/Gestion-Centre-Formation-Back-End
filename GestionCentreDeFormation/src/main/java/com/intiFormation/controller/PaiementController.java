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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Paiement;
import com.intiFormation.service.IFormationService;
import com.intiFormation.service.IPaiementService;
import com.intiFormation.service.IParticipantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaiementController {

	@Autowired
	IPaiementService paiementService;
	
	@Autowired
	IFormationService formationService;
	
	@Autowired
	IParticipantService participantService;
	
	@GetMapping("/assistant/paiement")
	public List<Paiement> chercherTtPaiement() {
		return paiementService.selectAll();
	}
	
	@GetMapping("/paiement/{id}")
	public Paiement chercherUnPaiement(@PathVariable("id") int id) {
		return paiementService.selectById(id);
	}
	
	
	@GetMapping("/paiementParticipant/{id}")
	public List<Paiement> chercherPaiementByParticipant(@PathVariable("id") int id) {
		return paiementService.selectByParticipant(id);
	}
	
	
	@GetMapping("/paiementResteByParticipant/{idParticipant}")
	public int chercherRestePaiement(@PathVariable("idParticipant") int idParticipant, 
			@RequestParam("idFormation") int idFormation) {
		
		return paiementService.chercherReste(participantService.selectById(idParticipant), formationService.selectById(idFormation).get());
	}
	
	
	@PostMapping("/paiement")
	public void ajoutPaiement(@RequestBody Paiement p) {
		paiementService.ajouter(p);
	}
	
	@PutMapping("/assistant/paiement")
	public void modificationPaiement(@RequestBody Paiement p) {
		paiementService.ajouter(p);
	}
	
	@DeleteMapping("/assistant/paiement/{id}")
	public void supprimerPaiement(@PathVariable("id") int id) {
		paiementService.supprimer(id);
	}
	
}
