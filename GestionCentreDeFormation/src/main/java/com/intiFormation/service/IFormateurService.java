package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Formateur;

public interface IFormateurService {

	public void ajouter(Formateur f);
	
	public void supprimer(int id);
	
	public Formateur selectById(int id);
	
	public List<Formateur> selectAll();
}
