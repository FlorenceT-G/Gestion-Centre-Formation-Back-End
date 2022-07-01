package com.intiFormation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Formation;

public interface IFormationDao extends JpaRepository<Formation, Integer> {

	public Formation save(Formation f);
	
	public void deleteById(int id);
	
	public Formation getById(int id);
	public Formation getByParticipant_idParticipant(int id);
	public Formation getByFormateur_idFormateur(int id);

	public List<Formation> getAll();
}