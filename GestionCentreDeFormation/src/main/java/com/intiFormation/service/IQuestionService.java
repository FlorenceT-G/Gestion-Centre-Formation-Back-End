package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Question;

public interface IQuestionService {
	
	
	public void ajouter(Question q);
	
	public void supprimer(int id);
	
	public void modifier(Question q);
	
	public List<Question> getAll();
	
	public Optional<Question> getById(int id);

}
