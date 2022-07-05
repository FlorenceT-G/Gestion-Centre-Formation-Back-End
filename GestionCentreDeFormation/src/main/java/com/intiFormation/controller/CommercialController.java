package com.intiFormation.controller;

import java.util.List;

import javax.transaction.Transactional;

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


import com.intiFormation.entity.Commercial;
import com.intiFormation.service.ICommercialService;
import com.intiFormation.service.IRoleService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200")
public class CommercialController {
	
	@Autowired
	ICommercialService commercialService;
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	@Autowired
	IRoleService roleService;
	
	
	@GetMapping("/commerciaux")
	public List<Commercial> AfficherAssistant() {
		
		List<Commercial> liste = commercialService.getAll();
		return liste;
	}
	
	
	@GetMapping("/commerciaux/{id}")
	public Commercial chercherUn(@PathVariable("id") int id)
	{
		Commercial c = commercialService.getById(id).get();
		return c;
	}
	
	
	@PostMapping("/commerciaux")
	public void ajouterCommercial(@RequestBody Commercial c) {
		
		c.setPassword(bc.encode(c.getPassword()));
		c.setRole(roleService.checherById(3).get());
		commercialService.ajouter(c);
	}
	
	
	@DeleteMapping("/commerciaux/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		commercialService.supprimer(id);

	}
	
	
	@PutMapping("/commerciaux")
	public void modifier(@RequestBody Commercial c) {
		
		commercialService.modifier(c);
		
	}
	

}
