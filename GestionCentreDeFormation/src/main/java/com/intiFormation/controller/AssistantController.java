package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.intiFormation.service.IRoleService;

@RestController
@CrossOrigin("http://localhost:4200")
public class AssistantController {
	
	@Autowired
	IAssistantService assistantService;
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/admin/assistants")
	public List<Assistant> AfficherAssistant() {
		
		List<Assistant> liste = assistantService.getAll();
		return liste;
	}
	
	
	@GetMapping("/admin/assistants/{id}")
	public Assistant chercherUn(@PathVariable("id") int id)
	{
		Assistant a = assistantService.getById(id).get();
		return a;
	}
	
	
	
	@PostMapping("/admin/assistants")
	public void ajouterAssistant(@RequestBody Assistant a) {
		
		a.setPassword(bc.encode(a.getPassword()));
		a.setRole(roleService.checherById(2).get());
		assistantService.ajouter(a);
	}
	
	
	@DeleteMapping("/admin/assistants/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		assistantService.supprimer(id);

	}
	
	
	@PutMapping("/assistant/assistants")
	public void modifier(@RequestBody Assistant a) {
		
		assistantService.modifier(a);
		
	}

}
