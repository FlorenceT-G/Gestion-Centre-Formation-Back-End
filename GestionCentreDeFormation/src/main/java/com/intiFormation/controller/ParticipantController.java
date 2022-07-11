package com.intiFormation.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Participant;
import com.intiFormation.entity.Prospect;
import com.intiFormation.service.IParticipantService;
import com.intiFormation.service.IRoleService;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ParticipantController {
	
	@Autowired
	IParticipantService IpService;
	
	@Autowired
	BCryptPasswordEncoder bc;
	
	@Autowired
	IRoleService roleService;
	
	@PostMapping("/assistant/participantsparprospect")
	public Integer inserer(@RequestBody Prospect p) {
		Participant participant = new Participant();
		
		participant.setNom(p.getNom());
		participant.setPrenom(p.getPrenom());
		
		String username = p.getPrenom().substring(0,1) + p.getNom().trim();
		username = username.replace(" ", "");
		participant.setUsername(username);
		participant.setAdresseMail(p.getEmail());
		
		participant.setPassword(bc.encode("1234"));
		participant.setRole(roleService.checherById(5).get());
		IpService.Ajouter(participant);
		
		System.out.println(participant.getIdUtilisateur());
		
		return participant.getIdUtilisateur();
	}
	
	@PostMapping("/assistant/participants")
	public void insererParticipant(@RequestBody Participant p) {
		
		p.setPassword(bc.encode(p.getPassword()));
		p.setRole(roleService.checherById(5).get());
		IpService.Ajouter(p);
	}
	

	@GetMapping("/assistant/participants")
	public List<Participant> aff()
	{
		List<Participant> Liste=  IpService.GetAll();
		return (Liste);
	}
	
	@GetMapping("/assistant/participants/{id}")
	public Participant selectid(@PathVariable("id") int id) {
		Participant p =  IpService.selectById(id);
		return (p);
	}
	
	@DeleteMapping ("/assistant/participants/{id}")
	public void supp(@PathVariable("id") int id)
	{
		IpService.supprimer(id);
	}
	
	@PutMapping("/participant")
	public void update(@RequestBody Participant p)
	{

		IpService.Modifier(p);
	}
	
	@GetMapping("/assistant/participants-paiementsNok")
	public List<Participant> afficherParticipantByPaiementNok()
	{
		return IpService.chercherByPaiementNok();
	}
	
	
	
}
