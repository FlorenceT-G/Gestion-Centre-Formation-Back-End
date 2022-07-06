package com.intiFormation.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IFormationDao;
import com.intiFormation.entity.Formation;

@Service
public class FormationService implements IFormationService{

	@Autowired
	IFormationDao formationDao;
	
	public void ajouter(Formation f) {
		formationDao.save(f);
	}
	
	public void supprimer(int id) {
		formationDao.deleteById(id);
	}
	
	public Optional<Formation> selectById(int id) {
		Optional<Formation> of = formationDao.findById(id);
		System.out.println(of.get().getLibFormation());
		return formationDao.findById(id);
	}
	
	public List<Formation> selectByIdParticipant(int id) {
		return formationDao.findByListeParticipants_idUtilisateur(id);
	}
	
	public List<Formation> selectByIdFormateur(int id) {
		return formationDao.findByFormateur_idUtilisateur(id);
	}


	public List<Formation> selectAll() {
		return formationDao.findAll();
	}
	
	
	public List<Formation> prochainesFormations(List<Formation> listeFormations ) {
		
		List<Formation> lFormationsProchaines = new ArrayList<>();
		LocalDate now = LocalDate.now();
		
		for(int i = 0 ; i < listeFormations.size() ; i++) {
			LocalDate dDebut = listeFormations.get(i).getDateDebut();
			System.out.println(dDebut);
			LocalDate dFin = listeFormations.get(i).getDateFin();
			
			System.out.println(dFin);
			
			if(dDebut.compareTo(now) > 0) {
				lFormationsProchaines.add(listeFormations.get(i));
			}
		}
		
		return lFormationsProchaines;
	}
	
	
	public List<Formation> FormationEnCours(List<Formation> listeFormations ) {
		
		List<Formation> listeFormationsEnCours = new ArrayList<>();
		
		LocalDate dateNow = LocalDate.now();
		
		System.out.println(dateNow);
		
		for(int i = 0 ; i < listeFormations.size() ; i++) {
			LocalDate dDebut = listeFormations.get(i).getDateDebut();
			System.out.println(dDebut);
			LocalDate dFin = listeFormations.get(i).getDateFin();
			
			System.out.println(dFin);
			if(dDebut.compareTo(dateNow) < 0 && dFin.compareTo(dateNow) > 0) {
				listeFormationsEnCours.add(listeFormations.get(i));
			}
		}
		return listeFormationsEnCours;
	}
	
	
	public List<Formation> HistoriqueFormation(List<Formation> listeFormations ) {
	
		List<Formation> listeHistoriqueFormation = new ArrayList<>();
		LocalDate dateNow = LocalDate.now();
		
		for(int i = 0 ; i < listeFormations.size() ; i++) {
			LocalDate dFin = listeFormations.get(i).getDateFin();
			if(dFin.compareTo(dateNow) < 0) {
				listeHistoriqueFormation.add(listeFormations.get(i));
			}
		}
		return listeHistoriqueFormation;
	}
	
}
