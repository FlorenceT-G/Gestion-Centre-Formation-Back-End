package com.intiFormation.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {

	public Optional<Utilisateur> findByUsername(String username);
	public List<Utilisateur> findByIdRole(int idRole); // à tester

}
