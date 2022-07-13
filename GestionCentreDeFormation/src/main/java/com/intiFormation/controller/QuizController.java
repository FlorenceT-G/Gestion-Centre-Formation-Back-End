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

import com.intiFormation.entity.Quiz;
import com.intiFormation.service.IQuizService;

@RestController	
@CrossOrigin("http://localhost:4200")
@RequestMapping("/formateur")
public class QuizController {
	
	
	@Autowired
	IQuizService quizService;
	
	
	@GetMapping("/quiz")
	public List<Quiz> AfficherQuiz() {
		
		List<Quiz> liste = quizService.getAll();
		return liste;
	}
	
	
	@GetMapping("/quiz/{id}")
	public Quiz chercherUn(@PathVariable("id") int id)
	{
		Quiz q = quizService.getById(id).get();
		return q;
	}
	
	
	
	@PostMapping("/quiz")
	public void ajouterQuiz(@RequestBody Quiz q) {
		

		quizService.ajouter(q);
	}
	
	
	@DeleteMapping("/quiz/{id}")
	public void supprimer(@PathVariable("id") int id)
	{
		quizService.supprimer(id);

	}
	
	
	@PutMapping("/quiz")
	public void modifier(@RequestBody Quiz q) {
		
		
		quizService.modifier(q);
		
	}

}
