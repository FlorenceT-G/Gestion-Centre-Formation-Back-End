package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IFormationDao;
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
	
	public Formation selectById(int id) {
		return ftionDao.getById(id);
	}
	
	public Formation selectByIdParticipant(int id) {
		return ftionDao.getByParticipant_idParticipant(id);
	}
	
	public Formation selectByIdFormateur(int id) {
		return ftionDao.getByFormateur_idFormateur(id);
	}
	
	public List<Formation> selectAll() {
		return ftionDao.getAll();
	}
	
}
