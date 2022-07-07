package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IPaiementDao;
import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Paiement;
import com.intiFormation.entity.Participant;

@Service
public class PaiementService implements IPaiementService {

	@Autowired
	IPaiementDao paiementDao;
	
	public void ajouter(Paiement p) {
		paiementDao.save(p);
	}
	
	public void supprimer(int id) {
		paiementDao.deleteById(id);
	}
	
	public Paiement selectById(int id) {
		return paiementDao.findById(id).get();
	}
	
	public List<Paiement> selectAll() {
		return paiementDao.findAll();
	}
	
	public List<Paiement> selectByParticipant(int id){
		return paiementDao.findByParticipant_idUtilisateur(id);
	}
	
	
	public int chercherReste (Participant p, Formation f) {
		
		int somme=0;
		
		for (int i=0; i< selectByParticipant(p.getIdUtilisateur()).size(); i++) {
			if (selectByParticipant(p.getIdUtilisateur()).get(i).getFormation()==f) {
				somme+=selectByParticipant(p.getIdUtilisateur()).get(i).getMontant();
			}
		}
		return f.getCout()-somme;
	}
}
