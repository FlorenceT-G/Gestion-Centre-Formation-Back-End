package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Paiement;

public interface IPaiementService {

	public void ajouter(Paiement p);
	
	public void supprimer(int id);
	
	public Paiement selectById(int id);
	
	public List<Paiement> selectAll();
}