package com.intiFormation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
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

import com.intiFormation.entity.Formation;
import com.intiFormation.service.IFormationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormationController {

	@Autowired
	IFormationService formationService;
	
	@PostMapping("/admin/formations")
	public void ajoutFormation(@RequestBody Formation f) {
		formationService.ajouter(f);
	}
	
	@PutMapping("/admin/formations")
	public void modificationFormation(@RequestBody Formation f) {
		formationService.ajouter(f);
	}
	
	@DeleteMapping("/admin/formations/{id}")
	public void supprimerFormation(@PathVariable("id") int id) {
		formationService.supprimer(id);
	}
	
	@GetMapping("/formations")
	public List<Formation> toutesFormations() {
		return formationService.selectAll();
	}
	
	@GetMapping("/prochaines-formations")
	public List<Formation> afficherProchainesFormations() {
		
		return formationService.prochainesFormations(toutesFormations());
	}
	
	@GetMapping("/formations-en-cours")
	public List<Formation> afficherFormationEnCours() {
		
		return formationService.FormationEnCours(toutesFormations());
	}
	

	
	@GetMapping("/historiqueFormations")
	public List<Formation> afficherHistoriqueFormation() {
	
		return formationService.HistoriqueFormation(toutesFormations());
	}
	

	@GetMapping("/formations/{id}")
	public Formation afficherFormation(@PathVariable("id") int id) {
		return formationService.selectById(id).get();
	}
	
	@GetMapping("/formationParticipant/{id}")
	public List<Formation> afficherFormationByParticipant(@PathVariable("id") int id) {
		return formationService.selectByIdParticipant(id);
	}
	
	@GetMapping("/formationParticipantPasPayees/{id}")
	public List<Formation> afficherFormationPasPayeesByParticipant(@PathVariable("id") int id) {
		return formationService.selectFormationPasPayeeByParticipant(id);
	}
	
	@GetMapping("/formationFormateur/{id}")
	public List<Formation> afficherFormationByFormateur(@PathVariable("id") int id) {
		return formationService.selectByIdFormateur(id);
	}
	
	@GetMapping("/formationQuiz/{id}")
	public Formation afficherFormationByQuiz(@PathVariable("id") int id) {
		return formationService.selectByIdQuiz(id);
	}
}
