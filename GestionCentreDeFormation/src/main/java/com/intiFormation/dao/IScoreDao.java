package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Score;

public interface IScoreDao extends JpaRepository<Score, Integer> {

	public List<Score> findByParticipant_idUtilisateur(int idParticipant);
	public List<Score> findByQuiz_Formation_idFormation(int idFormation);
}
