package com.intiFormation.service;

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
		return formationDao.findById(id);
	}
	
	public List<Formation> selectByIdParticipant(int id) {
		return formationDao.findByListeParticipants_idParticipant(id);
	}
	
	public List<Formation> selectByIdFormateur(int id) {
		return formationDao.findByFormateur_idFormateur(id);
	}
	
	public List<Formation> selectAll() {
		return formationDao.findAll();
	}
	
}
