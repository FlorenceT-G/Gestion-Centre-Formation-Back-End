package com.intiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Participant;

public interface IParticipantDao extends JpaRepository<Participant, Integer>{


}
