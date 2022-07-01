package com.intiFormation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IFormateurDao;
import com.intiFormation.entity.Formateur;

@Service
public class FormateurService implements IFormateurService {

	@Autowired
	IFormateurDao fteurDao;
	
	public void ajouter(Formateur f) {
		fteurDao.save(f);
	}
	
	public void supprimer(int id) {
		fteurDao.deleteById(id);
	}
}
