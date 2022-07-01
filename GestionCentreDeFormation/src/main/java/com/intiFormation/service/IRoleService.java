package com.intiFormation.service;

import java.util.List;
import java.util.Optional;

import com.intiFormation.entity.Role;

public interface IRoleService {
	
	public void nouveauRole(Role r);
	public void modifierRole(Role r);
	public void supprimierRole(int idRole);
	
	public List<Role> tousRoles();
	public Optional<Role> chercherParLibRole(String libRole);

}
