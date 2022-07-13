package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Reponse;

public interface IReponseDao extends JpaRepository<Reponse, Integer>{
	
	public List<Reponse> findByQuestion_idQuestion(int idQuestion);

}
