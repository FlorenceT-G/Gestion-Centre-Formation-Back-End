package com.intiFormation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Participant;
import com.intiFormation.service.IParticipantService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ParticipantController {
	
	IParticipantService IpService;
	
	@PostMapping("/Admin/ajoutParticipant")
	public void inserer(@RequestBody Participant participant)
	{
		IpService.Ajouter(participant);
	}

	@GetMapping("/Participants")
	public List<Participant> aff()
	{
		List<Participant> Liste=  IpService.GetAll();
		return (Liste);
	}
	
	@GetMapping("/Participant/{id}")
	public Participant selectid(@PathVariable("id") int id)
	{
		Participant p =  IpService.SelectById(id);
		return (p);
	}
	
	@DeleteMapping ("Assistant/SupprimerParticipant/{id}")
	public void supp(@PathVariable("id") int id)
	{
		IpService.supprimer(id);
	}
	
	@PutMapping("/Participant/UpdateParticipant")
	public void update(@RequestBody Participant p)
	{
		IpService.Modifier(p);
}
	
	
	
}
