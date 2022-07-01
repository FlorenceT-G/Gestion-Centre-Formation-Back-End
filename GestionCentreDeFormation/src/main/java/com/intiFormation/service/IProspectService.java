package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Prospect;

public interface IProspectService {
	
	public void Ajouter(Prospect p);
	
	public Prospect SelectById(Integer id);
	
	public List<Prospect> GetAll();
	
	public void Modifier(Prospect p);
	
	public void supprimer(int id);
	
	public Prospect SelectByEmail(String mail);
	
	public Prospect SelectByNum(Long num);
	
	public List<Prospect> SelectByNom(String Nom);
}
