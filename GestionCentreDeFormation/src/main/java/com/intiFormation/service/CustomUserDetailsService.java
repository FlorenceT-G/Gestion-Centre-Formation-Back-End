package com.intiFormation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intiFormation.entity.CustomUserDetails;
import com.intiFormation.entity.Utilisateur;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	IUtilisateurService utilisateurService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Utilisateur> utilisateur = utilisateurService.chercherParUsername(username);
		
		utilisateur.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));
		
		return new CustomUserDetails(utilisateur.get());
	}
	


}
