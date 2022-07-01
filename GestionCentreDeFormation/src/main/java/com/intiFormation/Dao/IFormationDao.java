package com.intiFormation.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Formation;

public interface IFormationDao extends JpaRepository<Formation, Integer> {

	public List<Formation> findByListeParticipants_idParticipant(int id);
	public List<Formation> findByFormateur_idFormateur(int id);

}