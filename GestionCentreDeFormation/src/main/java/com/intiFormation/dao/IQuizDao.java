package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Quiz;

public interface IQuizDao extends JpaRepository<Quiz, Integer> {

}
