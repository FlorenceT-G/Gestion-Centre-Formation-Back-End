package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Assistant;

public interface IAssistantDao extends JpaRepository<Assistant, Integer>{

}
