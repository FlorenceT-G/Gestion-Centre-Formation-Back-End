package com.intiFormation.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idQuestion;
	
	private String question;
	
	@OneToMany (mappedBy = "question")
	private List<Reponse> reponses;
	
	private int nbBonnesReponses;
	
	private String explication;
	
	@ManyToOne
	@JoinColumn(name = "idQuiz")
	private Quiz quiz;
	
	

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Reponse> getReponses() {
		return reponses;
	}

	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	public int getNbBonnesReponses() {
		return nbBonnesReponses;
	}

	public void setNbBonnesReponses(int nbBonnesReponses) {
		this.nbBonnesReponses = nbBonnesReponses;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Question() {
		super();
	}

	public String getExplication() {
		return explication;
	}

	public void setExplication(String explication) {
		this.explication = explication;
	}
	
	
	
	
	
	

}
