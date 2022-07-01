package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Relance;
import com.intiFormation.service.IRelanceService;

@RestController
public class RelanceController {
	
	@Autowired
	IRelanceService IrService;
	
	@PostMapping("/Assistant/ajoutRelance")
	public void inserer(@RequestBody Relance relance)
	{
		IrService.Ajouter(relance);
	}
	
	@GetMapping("/Assistant/Relances")
	public List<Relance> aff()
	{
		List<Relance> Liste = IrService.GetAll();
		return (Liste);
	}
	
	@GetMapping("/Assistant/Relances/{id}")
	public List<Relance> affbypar(@PathVariable("id") int id)
	{
		List<Relance> Liste=  IrService.GetByAssistant(id);
		return (Liste);
	}
	
	@GetMapping("/Participant/Relances/{id}")
	public List<Relance> affbyass(@PathVariable("id") int id)
	{
		List<Relance> Liste=  IrService.GetByParticipant(id);
		return (Liste);
	}
	
	@GetMapping("/Assistant/Relance/{id}")
	public Relance selectid(@PathVariable("id") int id)
	{
		Relance r = IrService.SelectById(id);
		return (r);
	}
	
	@DeleteMapping ("Assistant/SupprimerRelance/{id}")
	public void supp(@PathVariable("id") int id)
	{
		IrService.supprimer(id);
	}
	
	@PutMapping("/Assistant/UpdateRelance")
	public void update(@RequestBody Relance r)
	{
		IrService.Modifier(r);
	}
	

}
