package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IFormateurDao;
import com.intiFormation.entity.Formateur;

@Service
public class FormateurService implements IFormateurService {

	@Autowired
	IFormateurDao formateurDao;
	
	public void ajouter(Formateur f) {
		formateurDao.save(f);
	}
	
	public void supprimer(int id) {
		formateurDao.deleteById(id);
	}
	
	public Formateur selectById(int id) {
		return formateurDao.findById(id).get();
	}
	
	public List<Formateur> selectAll() {
		return formateurDao.findAll();
	}
}
