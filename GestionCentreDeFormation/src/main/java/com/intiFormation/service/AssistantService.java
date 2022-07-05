package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IAssistantDao;
import com.intiFormation.entity.Assistant;


@Service
public class AssistantService implements IAssistantService {

	@Autowired
	IAssistantDao assistantDao;
	
	
	public void ajouter(Assistant a) {
		
		assistantDao.save(a);
		
	}
	
	public void supprimer(int id) {
		
		assistantDao.deleteById(id);
	}
	
	
	public void modifier(Assistant a) {
		
		assistantDao.save(a);
	}
	
	
	public List<Assistant> getAll(){
		
		return assistantDao.findAll();
		
	}
	
	
	public Optional<Assistant> getById(int id){
		
		return assistantDao.findById(id);
	}
	
	
	
}
