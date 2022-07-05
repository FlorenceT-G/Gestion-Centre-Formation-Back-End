package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Role;
import com.intiFormation.service.IRoleService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class RoleController {
	
	
	@Autowired
	IRoleService roleService;
	
	@GetMapping("/roles/{id}")
	public Role chercherUn(@PathVariable("id") int id)
	{
		Role r = roleService.checherById(id).get();
		return r;
	}

}
