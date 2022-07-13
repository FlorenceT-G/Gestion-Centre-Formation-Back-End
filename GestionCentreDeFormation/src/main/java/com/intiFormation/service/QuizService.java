package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IQuizDao;
import com.intiFormation.entity.Quiz;

@Service
public class QuizService implements IQuizService {
	
	@Autowired
	IQuizDao quizDao;
	
	
	public void ajouter(Quiz q) {
		
		quizDao.save(q);
		
	}
	
	public void supprimer(int id) {
		
		quizDao.deleteById(id);
	}
	
	
	public void modifier(Quiz q) {
		
		quizDao.save(q);
	}
	
	
	public List<Quiz> getAll(){
		
		return quizDao.findAll();
		
	}
	
	public Optional<Quiz> getById(int id){
		
		return quizDao.findById(id);
	}
	

}
