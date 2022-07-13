package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Score;

public interface IScoreService {

	public void ajouterScore(Score s);
	public void modifierScore(Score s);
	public void supprimerScore(int idScore);
	public Optional<Score> selectById(int idScore);
	public List<Score> getScoreParParticipant(int idParticipant);
	public List<Score> getScoreParQuizFormation(int idFormation);
}
