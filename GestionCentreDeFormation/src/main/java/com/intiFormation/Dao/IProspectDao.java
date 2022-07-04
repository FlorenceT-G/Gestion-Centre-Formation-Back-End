package com.intiFormation.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Prospect;


public interface IProspectDao extends JpaRepository<Prospect, Integer>{
	
	public List<Prospect> findByNom(String nom);
	
	public Optional<Prospect> findByEmail(String email);
	
	public Optional<Prospect> findByNumTel(long numTel);
	

}
