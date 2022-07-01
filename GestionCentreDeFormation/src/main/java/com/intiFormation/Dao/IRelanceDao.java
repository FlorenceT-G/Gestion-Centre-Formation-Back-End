package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Relance;

public interface IRelanceDao extends JpaRepository<Relance, Integer>{
		
	public List<Relance> findByParticipant_idParticipant(int id);
	
	public List<Relance> findByAssistant_idAssistant(int id);
	

}
