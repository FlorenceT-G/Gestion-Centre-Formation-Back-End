package com.intiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Paiement;

public interface IPaiementDao extends JpaRepository<Paiement, Integer> {

	public List<Paiement> findByParticipant_idUtilisateur(int id);
}
