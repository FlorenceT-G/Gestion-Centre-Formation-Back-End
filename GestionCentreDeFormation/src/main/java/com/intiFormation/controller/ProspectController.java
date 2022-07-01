package com.intiFormation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.intiFormation.entity.Prospect;
import com.intiFormation.service.IProspectService;

public class ProspectController {
	
	IProspectService IpService;
	
	@PostMapping("/Admin/ajoutProspect")
	public void inserer(@RequestBody Prospect prospect)
	{
		IpService.Ajouter(prospect);
	}

	@GetMapping("/Prospects")
	public List<Prospect> aff()
	{
		List<Prospect> Liste=  IpService.GetAll();
		return (Liste);
	}
	
	@GetMapping("/Prospects/{nom}")
	public List<Prospect> affnom(@PathVariable("id") String nom)
	{
		List<Prospect> Liste=  IpService.SelectByNom(nom);
		return (Liste);
	}
	
	@GetMapping("/Prospect/{id}")
	public Prospect selectid(@PathVariable("id") int id)
	{
		Prospect p =  IpService.SelectById(id);
		return (p);
	}
	
	@GetMapping("/Prospect/{num}")
	public Prospect selectnum(@PathVariable("id") long num)
	{
		Prospect p =  IpService.SelectByNum(num);
		return (p);
	}
	
	@GetMapping("/Prospect/{mail}")
	public Prospect selectmail(@PathVariable("mail") String mail)
	{
		Prospect p =  IpService.SelectByEmail(mail);
		return (p);
	}
		
	@DeleteMapping ("Commercial/SupprimerProspect/{id}")
	public void supp(@PathVariable("id") int id)
	{
		IpService.supprimer(id);
	}
	
	@PutMapping("/Commercial/UpdateProspect")
	public void update(@RequestBody Prospect p)
	{
		IpService.Modifier(p);
}

}