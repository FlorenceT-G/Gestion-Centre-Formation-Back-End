package com.intiFormation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idScore;
	private float score;
	private float pourcentageVal;
	
	@ManyToOne
	@JoinColumn(name = "idParticipant")
	private Participant participant;
	
	@ManyToOne
	@JoinColumn(name = "idQuiz")
	private Quiz quiz;
	
	public float getPourcentageVal() {
		return pourcentageVal;
	}

	public void setPourcentageVal(float pourcentageVal) {
		this.pourcentageVal = pourcentageVal;
	}

	public int getIdScore() {
		return idScore;
	}

	public void setIdScore(int idScore) {
		this.idScore = idScore;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Score() {
		super();
	}
	
	
	
	

}
