package com.intiFormation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Formateur;

public interface IFormateurDao extends JpaRepository<Formateur, Integer>  {

}
