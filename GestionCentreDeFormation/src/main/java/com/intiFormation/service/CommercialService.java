package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.intiFormation.Dao.ICommercialDao;
import com.intiFormation.entity.Commercial;

@Service
public class CommercialService implements ICommercialService{
	
	@Autowired
	ICommercialDao commercialDao;
	
	
	
	public void ajouter(Commercial c) {
		
		commercialDao.save(c);
		
	}
	
	public void supprimer(int id) {
		
		commercialDao.deleteById(id);
	}
	
	
	public void modifier(Commercial c) {
		
		commercialDao.save(c);
	}
	
	
	public List<Commercial> getAll(){
		
		return commercialDao.findAll();
		
	}
	
	
	public Optional<Commercial> getById(int id){
		
		return commercialDao.findById(id);
	}

}
