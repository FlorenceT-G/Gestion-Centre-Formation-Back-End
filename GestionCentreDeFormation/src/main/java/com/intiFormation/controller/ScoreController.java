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
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Score;
import com.intiFormation.service.IScoreService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ScoreController {
	
	@Autowired
	IScoreService scoreService;
	
	@PostMapping("/scores")
	public void insertScore(@RequestBody Score s) {
		scoreService.ajouterScore(s);
	}
	
	@PutMapping("formateur/scores")
	public void updateScore(@RequestBody Score s) {
		scoreService.modifierScore(s);
	}
	
	@DeleteMapping("formateur/scores/{idScore}")
	public void deleteScore(@PathVariable("idScore") int idScore) {
		scoreService.supprimerScore(idScore);
	}
	
	@GetMapping("participant/scores/{idParticipant}")
	public List<Score> selectScoresByParticipant(@PathVariable("idParticipant") int idParticipant) {
		return scoreService.getScoreParParticipant(idParticipant);
	}
	
	@GetMapping("/scores/{idFormation}")
	public List<Score> selectScoresByFormation(@PathVariable("idFormation") int idFormation) {
		return scoreService.getScoreParQuizFormation(idFormation);
	}

}
