package com.intiFormation.service;

import com.intiFormation.entity.Prospect;

public interface IProspectService {
	
	public void Ajouter(Prospect p);
	
	public Prospect SelectById(Integer id);
	
	public void Modifier(Prospect p);
	
	public void supprimer(int id);
	
	public Prospect SelectByEmail(String mail);
	
}
