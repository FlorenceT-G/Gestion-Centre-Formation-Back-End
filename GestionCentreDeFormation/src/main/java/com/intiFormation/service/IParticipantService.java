package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Participant;

public interface IParticipantService {
	
	
	public void Ajouter(Participant r);
	
	public Participant SelectById(Integer id);
	
	public List<Participant> GetAll();
	
	public void Modifier(Participant r);
	
	public void supprimer(int id);

}
