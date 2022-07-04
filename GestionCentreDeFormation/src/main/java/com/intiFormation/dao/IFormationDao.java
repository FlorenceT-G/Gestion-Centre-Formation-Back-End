package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Formation;

public interface IFormationDao extends JpaRepository<Formation, Integer> {

	public List<Formation> findByListeParticipants_idUtilisateur(int idParticipant);
	public List<Formation> findByFormateur_idUtilisateur(int idFormateur);

}