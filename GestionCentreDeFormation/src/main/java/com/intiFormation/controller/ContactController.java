package com.intiFormation.controller;

import java.util.List;

import javax.transaction.Transactional;

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


import com.intiFormation.entity.Contact;
import com.intiFormation.service.IContactService;

@RestController 
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class ContactController {
	
	
	
	@Autowired
	IContactService contactService;
	
	
	@GetMapping("/contacts")
	public List<Contact> AfficherContact() {
		
		List<Contact> liste = contactService.getAll();
		return liste;
	}
	
	
	@GetMapping("/contacts/{id}")
	public Contact chercherUn(@PathVariable("id") int id)
	{
		Contact c = contactService.getById(id).get();
		return c;
	}
	
	
	
	@PostMapping("/contacts")
	public void ajouterContact(@RequestBody Contact c) {
		
		contactService.ajouter(c);
	}
	
	
	@DeleteMapping("/contacts/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		contactService.supprimer(id);

	}
	
	
	@PutMapping("/contacts")
	public void modifier(@RequestBody Contact c) {
		
		contactService.modifier(c);
		
	}

}
