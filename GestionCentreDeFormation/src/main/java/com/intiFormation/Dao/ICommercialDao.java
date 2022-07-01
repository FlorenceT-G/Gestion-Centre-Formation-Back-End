package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Commercial;


public interface ICommercialDao extends JpaRepository<Commercial, Integer>{

}
