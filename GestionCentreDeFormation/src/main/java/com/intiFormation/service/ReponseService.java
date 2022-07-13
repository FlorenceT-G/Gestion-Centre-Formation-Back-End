package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IReponseDao;
import com.intiFormation.entity.Reponse;

@Service
public class ReponseService implements IReponseService {
	
	@Autowired
	IReponseDao reponseDao;
	
	public void ajouterReponse(Reponse r) {
		reponseDao.save(r);
	}
	
	public void modifierReponse(Reponse r) {
		reponseDao.save(r);
	}
	
	public void supprimerReponse(int idReponse) {
		reponseDao.deleteById(idReponse);
	}
	
	public Optional<Reponse> selectById(int idReponse) {
		return reponseDao.findById(idReponse);
	}
	
	public List<Reponse> getAllReponseForQuestion(int idQuestion) {
		return reponseDao.findByQuestion_idQuestion(idQuestion);
	}

}
