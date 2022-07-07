package com.intiFormation.service;

import java.util.List;

import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Paiement;
import com.intiFormation.entity.Participant;

public interface IPaiementService {

	public void ajouter(Paiement p);
	
	public void supprimer(int id);
	
	public Paiement selectById(int id);
	
	public List<Paiement> selectAll();
	
	public List<Paiement> selectByParticipant(int id);
	
	public int chercherReste (Participant p, Formation f);
}