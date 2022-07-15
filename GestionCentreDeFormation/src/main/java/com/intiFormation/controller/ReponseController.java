package com.intiFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Reponse;
import com.intiFormation.service.IQuestionService;
import com.intiFormation.service.IReponseService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ReponseController {
	
	@Autowired
	IReponseService reponseService;
	
	@Autowired
	IQuestionService questionService;
	
	@PostMapping("formateur/reponses/{idq}")
	public void insertReponse(@RequestBody Reponse r,@PathVariable("idq") int id) {
		r.setQuestion(questionService.getById(id).get());
		reponseService.ajouterReponse(r);
	}
	
	@PutMapping("formateur/reponses/{idq}")
	public void updateReponse(@RequestBody Reponse r,@PathVariable("idq") int id) {
		
		r.setQuestion(questionService.getById(id).get());
		reponseService.modifierReponse(r);
	}
	
	@DeleteMapping("formation/reponses/{idReponse}")
	public void deleteReponse(@PathVariable("idReponse") int idReponse) {
		reponseService.supprimerReponse(idReponse);
	}
	
	@GetMapping("reponses/{idReponse}")
	public Reponse selectReponseByID(@PathVariable("idReponse") int idReponse) {
		return reponseService.selectById(idReponse).get();
	}
	
	@GetMapping("reponses/{idQuestion}")
	public List<Reponse> selectReponseByQuestion(@PathVariable("idQuestion") int idQuestion) {
		return reponseService.getAllReponseForQuestion(idQuestion);
	}
}
