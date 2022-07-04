package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IPaiementDao;
import com.intiFormation.entity.Paiement;

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
}
