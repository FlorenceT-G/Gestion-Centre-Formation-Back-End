package com.intiFormation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formation;
import com.intiFormation.service.IFormationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormationController {

	@Autowired
	IFormationService ftionService;
	
	@PostMapping("/admin/formation")
	public void ajoutFormation(Formation f) {
		ftionService.ajouter(f);
	}
	
	@DeleteMapping("/admin/formation")
	public void supprimerFormation(int id) {
		ftionService.supprimer(id);
	}
	
	@GetMapping("/formation")
	public List<Formation> afficherFormationEnCours() {
		List<Formation> listeFormations = ftionService.selectAll();
		List<Formation> listeFormationsEnCours = new ArrayList<>();
		
		LocalDate dateNow = LocalDate.now();
		for(int i=0;i<listeFormations.size();i++) {
			LocalDate dDebut = listeFormations.get(i).getDateDebut();
			LocalDate dFin = listeFormations.get(i).getDateFin();
			if(dDebut.compareTo(dateNow) < 0 && dFin.compareTo(dateNow) > 0) {
				listeFormationsEnCours.add(listeFormations.get(i));
			}
		}
		return listeFormationsEnCours;
	}
	
	@GetMapping("/historiqueFormation")
	public List<Formation> afficherHistoriqueFormation() {
		List<Formation> listeFormations = ftionService.selectAll();
		List<Formation> listeHistoriqueFormation = new ArrayList<>();
		LocalDate dateNow = LocalDate.now();
		
		for(int i=0; i<listeFormations.size(); i++) {
			LocalDate dFin = listeFormations.get(i).getDateFin();
			if(dFin.compareTo(dateNow) > 0) {
				listeHistoriqueFormation.add(listeFormations.get(i));
			}
		}
		return listeHistoriqueFormation;
	}
	
	@GetMapping("/formation/{id}")
	public Formation afficherFormation(int id) {
		return ftionService.selectById(id).get();
	}
	
	@GetMapping("/formationParticipant/{id}")
	public List<Formation> afficherFormationByParticipant(int id) {
		return ftionService.selectByIdParticipant(id);
	}
	
	@GetMapping("/formationFormateur/{id}")
	public List<Formation> afficherFormationByFormateur(int id) {
		return ftionService.selectByIdFormateur(id);
	}
	
}
