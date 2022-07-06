package com.intiFormation.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formateur;
import com.intiFormation.entity.Formation;
import com.intiFormation.service.IFormateurService;
import com.intiFormation.service.IFormationService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class FormateurController {

	@Autowired
	IFormateurService formateurService;
	
	@Autowired
	IFormationService formationService;
	
	@GetMapping("/formateur")
	public List<Formateur> chercherTtFormateur() {
		return formateurService.selectAll();
	}
	
	@GetMapping("/formateur/{id}")
	public Formateur chercherFormateur(@PathVariable("id") int id) {
		return formateurService.selectById(id);
	}
	
	@PostMapping("/formateur")
	public void ajoutFormateur(@RequestBody Formateur f) {
		formateurService.ajouter(f);
	}
	
	@PutMapping("/formateur")
	public void modificationFormateur(@RequestBody Formateur f) {
		formateurService.ajouter(f);
	}
	
	@DeleteMapping("/formateur/{id}")
	public void supprimerFormateur(@PathVariable("id") int id) {
		formateurService.supprimer(id);
	}
	
	
	
	@GetMapping("/formateurDispo")
	public List<Formateur> chercherFormateurDispo() {
		
		List<Formateur> listeFormateur = formateurService.selectAll();
		List<Formateur> listeFormateursDispo = new ArrayList<>();
		
		for (int i = 0 ; i < listeFormateur.size() ; i++) {
			
			if (
			formationService.FormationEnCours(listeFormateur.get(i).getListeFormations()).isEmpty() &&
			formationService.prochainesFormations(listeFormateur.get(i).getListeFormations()).isEmpty()) 
			{
				listeFormateursDispo.add(listeFormateur.get(i));
			}
			
			
		}
		return listeFormateursDispo;
		
	}
	
}
