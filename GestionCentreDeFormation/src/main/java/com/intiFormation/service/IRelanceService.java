package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Relance;

public interface IRelanceService {
	
	public void Ajouter(Relance r);
	
	public Relance SelectById(Integer id);
	
	public void Modifier(Relance r);
	
	public void supprimer(int id);
	
	public List<Relance> GetByParticipant(Integer id);
	
	public List<Relance> GetByAssistant(Integer id);

}
