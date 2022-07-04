package com.intiFormation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.intiFormation.entity.Role;

public interface IRoleDao extends JpaRepository<Role, Integer>{
	
	public Optional<Role> findByLibRole(String libRole);

}