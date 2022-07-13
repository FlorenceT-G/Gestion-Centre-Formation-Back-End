package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IScoreDao;
import com.intiFormation.entity.Score;

@Service
public class ScoreService implements IScoreService {
	
	@Autowired
	IScoreDao scoreDao;
	
	public void ajouterScore(Score s) {
		scoreDao.save(s);
	}
	
	public void modifierScore(Score s) {
		scoreDao.save(s);
	}
	
	public void supprimerScore(int idScore) {
		scoreDao.deleteById(idScore);
	}
	
	public Optional<Score> selectById(int idScore) {
		return scoreDao.findById(idScore);
	}
	
	public List<Score> getScoreParParticipant(int idParticipant) {
		return scoreDao.findByParticipant_idUtilisateur(idParticipant);
	}
	
	public List<Score> getScoreParQuizFormation(int idFormation) {
		return scoreDao.findByQuiz_Formation_idFormation(idFormation);
	}

}
