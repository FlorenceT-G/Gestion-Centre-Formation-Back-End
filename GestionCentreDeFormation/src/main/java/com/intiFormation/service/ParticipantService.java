package com.intiFormation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IParticipantDao;
import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Participant;

@Service
public class ParticipantService implements IParticipantService {
	
	
	@Autowired
	IParticipantDao IpDao;
	
	
	public void Ajouter(Participant r)
	{IpDao.save(r);}
	
	public Participant selectById(Integer id) { 
		return IpDao.findById(id).get();
	}
	
	public List<Participant> GetAll()
	{	return  IpDao.findAll();}
	
	public void Modifier(Participant r)
	{IpDao.save(r);}
	
	public void supprimer(int id)
	{IpDao.deleteById(id);}
	
	
	public List<Participant> chercherByPaiementNok(){
		
		List<Participant> listeParticipants = new ArrayList<>();
		
		for (int i=0; i<GetAll().size(); i++) {
			
			int sommeAPayer=0;
			int sommePayee=0;
			
			for (int j=0; j<GetAll().get(i).getListeFormations().size(); j++) {
				sommeAPayer+= GetAll().get(i).getListeFormations().get(j).getCout();
			}
			for(int k=0; k<GetAll().get(i).getPaiements().size(); k++){
				sommePayee+= GetAll().get(i).getPaiements().get(k).getMontant();
			}
			if (sommeAPayer!=sommePayee){
				listeParticipants.add(GetAll().get(i));
			}
		}
		return listeParticipants;
	}


}
