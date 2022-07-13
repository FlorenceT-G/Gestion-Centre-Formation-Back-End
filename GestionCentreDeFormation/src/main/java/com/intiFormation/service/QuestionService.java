package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IQuestionDao;
import com.intiFormation.entity.Question;

@Service
public class QuestionService implements IQuestionService{
	
	@Autowired
	IQuestionDao questionDao;
	
	
	public void ajouter(Question q) {
		
		questionDao.save(q);
		
	}
	
	public void supprimer(int id) {
		
		questionDao.deleteById(id);
	}
	
	
	public void modifier(Question q) {
		
		questionDao.save(q);
	}
	
	
	public List<Question> getAll(){
		
		return questionDao.findAll();
		
	}
	
	
	public Optional<Question> getById(int id){
		
		return questionDao.findById(id);
	}


}
