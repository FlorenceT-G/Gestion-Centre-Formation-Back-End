package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Assistant;

public interface IAssistantService {
	
	
	
	public void ajouter(Assistant a);
	
	public void supprimer(int id);

	public void modifier(Assistant a);
	
	public List<Assistant> getAll();
	
	public Optional<Assistant> getById(int id);

}
