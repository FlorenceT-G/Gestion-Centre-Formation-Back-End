package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formateur;
import com.intiFormation.service.IFormateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormateurController {

	@Autowired
	IFormateurService fteurService;
	
	@PostMapping("/admin/formateur")
	public void ajoutFormateur(Formateur f) {
		fteurService.ajouter(f);
	}
	
	@DeleteMapping("/admin/formateur")
	public void supprimerFormateur(int id) {
		fteurService.supprimer(id);
	}
	
}
