package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiFormation.Dao.IRoleDao;
import com.intiFormation.entity.Role;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	IRoleDao roleDao;
	
	public void nouveauRole(Role r) {
		roleDao.save(r);
	}
	
	public void modifierRole(Role r) {
		roleDao.save(r);
	}
	
	public void supprimierRole(int idRole) {
		roleDao.deleteById(idRole);
	}
	
	public List<Role> tousRoles() {
		return roleDao.findAll();
	}
	
	public Optional<Role> chercherParLibRole(String libRole) {
		return roleDao.findByLibrole(libRole);
	}

}
