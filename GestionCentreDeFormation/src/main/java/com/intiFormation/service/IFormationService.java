package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Formation;

public interface IFormationService {
	
	public void ajouter(Formation f);
	public void supprimer(int id);
	
	public Optional<Formation> selectById(int id);
	public List<Formation> selectByIdParticipant(int id);
	public List<Formation> selectByIdFormateur(int id);
	public List<Formation> selectAll();
	public List<Formation> prochainesFormations(List<Formation> listeFormations);
	public List<Formation> FormationEnCours(List<Formation> listeFormations);
	public List<Formation> HistoriqueFormation(List<Formation> listeFormations);
	List<Formation> selectFormationPasPayeeByParticipant(int id);
	public Formation selectByIdQuiz(int id);
	
}
