package com.intiFormation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Relance;

public interface IRelanceDao extends JpaRepository<Relance, Integer>{
		
	public List<Relance> findByParticipant_idUtilisateur(int idParticipant);
	
	public List<Relance> findByAssistant_idUtilisateur(int idAssistant);
	

}
