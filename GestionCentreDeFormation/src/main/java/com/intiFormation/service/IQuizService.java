package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Quiz;

public interface IQuizService {
	
	
	public void ajouter(Quiz q);
	
	public void supprimer(int id);
	
	public void modifier(Quiz q);
	
	public List<Quiz> getAll();
	
	public Optional<Quiz> getById(int id);

}
