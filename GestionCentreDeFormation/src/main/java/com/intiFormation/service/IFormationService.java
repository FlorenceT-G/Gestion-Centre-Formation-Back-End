package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Formation;

public interface IFormationService {
	
	public void ajouter(Formation f);
	public void supprimer(int id);
	
	public Formation selectById(int id);
	public Formation selectByIdParticipant(int id);
	public Formation selectByIdFormateur(int id);
	public List<Formation> selectAll();
	
}
