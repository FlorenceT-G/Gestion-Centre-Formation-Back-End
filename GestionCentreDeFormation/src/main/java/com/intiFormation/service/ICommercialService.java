package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Commercial;

public interface ICommercialService {
	
	
	public void ajouter(Commercial c);
	
	public void supprimer(int id);
	
	public void modifier(Commercial c);
	
	public List<Commercial> getAll();
	
	public Optional<Commercial> getById(int id);

}
