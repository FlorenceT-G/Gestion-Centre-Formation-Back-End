package com.intiFormation.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Participant;
import com.intiFormation.service.IParticipantService;



@RestController
@RequestMapping("/assistant")
@CrossOrigin(origins="http://localhost:4200")
public class ParticipantController {
	
	@Autowired
	IParticipantService IpService;
	
	@PostMapping("/participants")
	public void inserer(@RequestBody Participant participant)
	{
		IpService.Ajouter(participant);
	}

	@GetMapping("/participants")
	public List<Participant> aff()
	{
		List<Participant> Liste=  IpService.GetAll();
		return (Liste);
	}
	
	@GetMapping("/participants/{id}")
	public Participant selectid(@PathVariable("id") int id) {
		Participant p =  IpService.selectById(id);
		return (p);
	}
	
	@DeleteMapping ("/participants/{id}")
	public void supp(@PathVariable("id") int id)
	{
		IpService.supprimer(id);
	}
	
	@PutMapping("/participants")
	public void update(@RequestBody Participant p)
	{
		IpService.Modifier(p);
	}
	
	
	
}
