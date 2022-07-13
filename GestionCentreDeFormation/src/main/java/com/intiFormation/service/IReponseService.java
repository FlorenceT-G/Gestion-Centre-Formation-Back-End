package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Reponse;

public interface IReponseService {
	
	public void ajouterReponse(Reponse r);
	public void modifierReponse(Reponse r);
	public void supprimerReponse(int idReponse);
	public Optional<Reponse> selectById(int idReponse);
	public List<Reponse> getAllReponseForQuestion(int idQuestion);

}
