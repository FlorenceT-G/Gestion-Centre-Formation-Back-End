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

import com.intiFormation.entity.Assistant;
import com.intiFormation.service.IAssistantService;

@RestController 
@RequestMapping("/Admin")
@CrossOrigin(origins="http://localhost:4200")
public class AssistantController {
	
	@Autowired
	IAssistantService assistantService;
	
	@GetMapping("/assistants")
	public List<Assistant> AfficherAssistant() {
		
		List<Assistant> liste = assistantService.getAll();
		return liste;
	}
	
	
	@GetMapping("/assistants/{id}")
	public Assistant chercherUn(@PathVariable("id") int id)
	{
		Assistant a = assistantService.getById(id).get();
		return a;
	}
	
	
	
	@PostMapping("/assistants")
	public void ajouterAssistant(@RequestBody Assistant a) {
		
		assistantService.ajouter(a);
	}
	
	
	@DeleteMapping("/assistants/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		assistantService.supprimer(id);

	}
	
	
	@PutMapping("/assistants")
	public void modifier(@RequestBody Assistant a) {
		
		assistantService.modifier(a);
		
	}

}
