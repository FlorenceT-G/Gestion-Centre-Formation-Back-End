package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Formateur;

public interface IFormateurDao extends JpaRepository<Formateur, Integer>  {

	public Formateur save(Formateur f);
	
	public void deleteById(int id);
}
