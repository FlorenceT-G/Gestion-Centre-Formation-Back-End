package com.intiFormation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	public Optional<Utilisateur> findById(int id);
	public Optional<Utilisateur> findByUsername(String username);
	public List<Utilisateur> findByRole_idRole(int idRole); // à tester

}
