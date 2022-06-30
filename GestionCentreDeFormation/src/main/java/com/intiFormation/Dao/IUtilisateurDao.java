package com.intiFormation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiFormation.entity.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer> {
	
	
	public Utilisateur findByLogin(String login);
	
	//public Utilisateur findByNomProduit(String nom);
	
	
	@Query("SELECT U FROM Utilisateur U WHERE U.nom = ?1")
	public Utilisateur fByNomUser(String nom);

}
