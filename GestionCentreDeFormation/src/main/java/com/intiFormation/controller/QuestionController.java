package com.intiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Question;
import com.intiFormation.service.IQuestionService;
import com.intiFormation.service.IQuizService;

@RestController	
@CrossOrigin("http://localhost:4200")
@RequestMapping("/formateur")
public class QuestionController {
	
	
	@Autowired
	IQuestionService questionService;
	
	@Autowired
	IQuizService quizService;
	
	
	@GetMapping("/questions")
	public List<Question> AfficherQuestion() {
		
		List<Question> liste = questionService.getAll();
		return liste;
	}
	
	
	@GetMapping("/questions/{id}")
	public Question chercherUn(@PathVariable("id") int id)
	{
		Question q = questionService.getById(id).get();
		return q;
	}
	
	
	
	@PostMapping("/questions/{idq}")
	public void ajouterQuestion(@RequestBody Question q, @PathVariable("idq") int id) {
		q.setQuiz(quizService.getById(id).get());
		questionService.ajouter(q);
	}
	
	
	@DeleteMapping("/questions/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		questionService.supprimer(id);

	}
	
	
	@PutMapping("/questions/{idq}")
	public void modifier(@RequestBody Question q, @PathVariable("idq") int id) {
		
		q.setQuiz(quizService.getById(id).get());
		questionService.modifier(q);
		
	}

}
