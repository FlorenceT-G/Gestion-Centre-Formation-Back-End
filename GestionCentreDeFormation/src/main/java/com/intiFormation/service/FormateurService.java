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
		System.out.println(f.getNom());
		formateurDao.save(f);
	}
	
	public void supprimer(int id) {
		formateurDao.deleteById(id);
	}
	
	public List<Formateur> selectAll() {
		return formateurDao.findAll();
	}
	
	public Formateur selectById(int id) {
		Formateur f =  formateurDao.findById(id).get();
		System.out.println(f.getNom());
		return f;
	}
}
