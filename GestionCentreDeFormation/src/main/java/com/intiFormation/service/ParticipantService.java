package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IParticipantDao;
import com.intiFormation.entity.Participant;



@Service
public class ParticipantService implements IParticipantService {
	
	
	@Autowired
	IParticipantDao IpDao;
	
	
	public void Ajouter(Participant r)
	{IpDao.save(r);}
	
	public Participant SelectById(Integer id)
	{ return IpDao.findById(id).get();}
	
	public List<Participant> GetAll()
	{	return  IpDao.findAll();}
	
	public void Modifier(Participant r)
	{IpDao.save(r);}
	
	public void supprimer(int id)
	{IpDao.deleteById(id);}

}
