package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.intiFormation.Dao.IAssistantDao;
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
