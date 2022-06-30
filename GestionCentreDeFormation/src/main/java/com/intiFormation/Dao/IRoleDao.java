package com.intiFormation.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiFormation.entity.Role;



public interface IRoleDao extends JpaRepository<Role, Integer>{
	
	
	public Role findByLibrole(String nom);
	


}