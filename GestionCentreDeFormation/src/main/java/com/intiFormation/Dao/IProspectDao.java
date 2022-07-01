package com.intiFormation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Prospect;


public interface IProspectDao extends JpaRepository<Prospect, Integer>{
	
	public Prospect findByNom(String nom);
	
	public Prospect findByEmail(String email);
	
	public Prospect findByNumTel(long numTel);
	

}
