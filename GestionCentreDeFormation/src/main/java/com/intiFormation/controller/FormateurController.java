package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formateur;
import com.intiFormation.service.IFormateurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormateurController {

	@Autowired
	IFormateurService formateurService;
	
	@PostMapping("/admin/formateur")
	public void ajoutFormateur(@RequestBody Formateur f) {
		formateurService.ajouter(f);
	}
	
	@PutMapping("/admin/formateur")
	public void modificationFormateur(@RequestBody Formateur f) {
		formateurService.ajouter(f);
	}
	
	@DeleteMapping("/admin/formateur/{id}")
	public void supprimerFormateur(@PathVariable("id") int id) {
		formateurService.supprimer(id);
	}
	
	@GetMapping("/admin/formateur")
	public void chercherTtFormateur() {
		formateurService.selectAll();
	}
	
	@GetMapping("/admin/formateur/{id}")
	public void chercherFormateur(@PathVariable("id") int id) {
		formateurService.selectById(id);
	}
	
}
