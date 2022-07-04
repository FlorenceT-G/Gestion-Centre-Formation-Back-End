package com.intiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IProspectDao;
import com.intiFormation.entity.Prospect;

@Service
public class ProspectService implements IProspectService {
	
	@Autowired
	IProspectDao IpDao;
	
	public void Ajouter(Prospect p)
	{IpDao.save(p);}
	
	public Prospect SelectById(Integer id)
	{ return IpDao.findById(id).get();}
	
	public void Modifier(Prospect p)
	{IpDao.save(p);}
	
	public void supprimer(int id)
	{IpDao.deleteById(id);}
	
	public List<Prospect> GetAll()
	{	return  IpDao.findAll();}
	
	public Prospect SelectByEmail(String mail)
	{ return IpDao.findByEmail(mail).get();}
	
	public Prospect SelectByNum(Long num)
	{ return IpDao.findByNumTel(num).get();}
	
	public List<Prospect> SelectByNom(String Nom)
	{ return IpDao.findByNom(Nom);}

}
