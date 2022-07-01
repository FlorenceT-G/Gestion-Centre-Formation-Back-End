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
	IFormationDao ftionDao;
	
	public void ajouter(Formation f) {
		ftionDao.save(f);
	}
	
	public void supprimer(int id) {
		ftionDao.deleteById(id);
	}
	
	public Optional<Formation> selectById(int id) {
		return ftionDao.findById(id);
	}
	
	public List<Formation> selectByIdParticipant(int id) {
		return ftionDao.findByListeParticipants_idUtilisateur(id);
	}
	
	public List<Formation> selectByIdFormateur(int id) {
		return ftionDao.findByFormateur_idUtilisateur(id);
	}
	
	public List<Formation> selectAll() {
		return ftionDao.findAll();
	}
	
}
