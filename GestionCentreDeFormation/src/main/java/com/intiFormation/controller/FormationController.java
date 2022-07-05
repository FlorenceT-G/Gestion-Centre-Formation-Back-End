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
	public List<Formation> prochainesFormations() {
		List<Formation> lFormations = formationService.selectAll();
		List<Formation> lFormationsProchaines = new ArrayList<>();
		LocalDate now = LocalDate.now();
		
		for(int i = 0 ; i < lFormations.size() ; i++) {
			LocalDate dDebut = lFormations.get(i).getDateDebut();
			System.out.println(dDebut);
			LocalDate dFin = lFormations.get(i).getDateFin();
			
			System.out.println(dFin);
			
			if(dDebut.compareTo(now) > 0) {
				lFormationsProchaines.add(lFormations.get(i));
			}
		}
		
		return lFormationsProchaines;
	}
	
	@GetMapping("/formations-en-cours")
	public List<Formation> afficherFormationEnCours() {
		List<Formation> listeFormations = formationService.selectAll();
		List<Formation> listeFormationsEnCours = new ArrayList<>();
		
		LocalDate dateNow = LocalDate.now();
		
		System.out.println(dateNow);
		
		for(int i = 0 ; i < listeFormations.size() ; i++) {
			LocalDate dDebut = listeFormations.get(i).getDateDebut();
			System.out.println(dDebut);
			LocalDate dFin = listeFormations.get(i).getDateFin();
			
			System.out.println(dFin);
			if(dDebut.compareTo(dateNow) < 0 && dFin.compareTo(dateNow) > 0) {
				listeFormationsEnCours.add(listeFormations.get(i));
			}
		}
		return listeFormationsEnCours;
	}
	
	@GetMapping("/historiqueFormations")
	public List<Formation> afficherHistoriqueFormation() {
		List<Formation> listeFormations = formationService.selectAll();
		List<Formation> listeHistoriqueFormation = new ArrayList<>();
		LocalDate dateNow = LocalDate.now();
		
		for(int i = 0 ; i < listeFormations.size() ; i++) {
			LocalDate dFin = listeFormations.get(i).getDateFin();
			if(dFin.compareTo(dateNow) > 0) {
				listeHistoriqueFormation.add(listeFormations.get(i));
			}
		}
		return listeHistoriqueFormation;
	}
	
	@GetMapping("/formations/{id}")
	public Formation afficherFormation(@PathVariable("id") int id) {
		return formationService.selectById(id).get();
	}
	
	@GetMapping("/formationParticipant/{id}")
	public List<Formation> afficherFormationByParticipant(@PathVariable("id") int id) {
		return formationService.selectByIdParticipant(id);
	}
	
	@GetMapping("/formationFormateur/{id}")
	public List<Formation> afficherFormationByFormateur(@PathVariable("id") int id) {
		return formationService.selectByIdFormateur(id);
	}
	
}
