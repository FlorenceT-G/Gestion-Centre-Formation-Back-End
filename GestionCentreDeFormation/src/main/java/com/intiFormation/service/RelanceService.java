package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.dao.IRelanceDao;
import com.intiFormation.entity.Relance;

@Service
public class RelanceService implements IRelanceService{
	
	@Autowired
	IRelanceDao IrDao;
	
	public void Ajouter(Relance r)
	{IrDao.save(r);}
	
	public Relance SelectById(Integer id)
	{ return IrDao.findById(id).get();}
	
	public void Modifier(Relance r)
	{IrDao.save(r);}
	
	public void supprimer(int id)
	{IrDao.deleteById(id);}
	
	public List<Relance> GetByParticipant(Integer id)
	{ return IrDao.findByParticipant_idUtilisateur(id);}
	
	public List<Relance> GetByAssistant(Integer id)
	{ return IrDao.findByAssistant_idUtilisateur(id);}
	
	public List<Relance> GetAll()
	{	return  IrDao.findAll();}

}
