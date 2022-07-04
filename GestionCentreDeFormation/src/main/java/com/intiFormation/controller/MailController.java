package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Participant;
import com.intiFormation.service.FormationService;
import com.intiFormation.service.ParticipantService;

@RestController
@CrossOrigin("http://localhost:4200")
public class MailController {
	
	@Autowired
	public JavaMailSender sender;
	@Autowired
	ParticipantService pService;
	@Autowired
	FormationService fService;
	
	@ResponseBody
	@RequestMapping("/sendmail")
	public String envoieMail() {
		
		Participant p = pService.selectById(1);
		
		System.out.println(p.getPrenom());
		
		Formation f = fService.selectById(1).get();
		
		System.out.println(f.getLibFormation());
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("tgflorence890@gmail.com");
		message.setSubject("Inscription à la formation " + f.getLibFormation());
		message.setText("Bonjour " + p.getNom() + " " + p.getPrenom() 
		+ ", \n Merci de votre inscription à la formation " + f.getLibFormation()
		+ ".\nPour plus de détail rendez-vous sur votre compte !"
		+ "\n\nCordialement,\nL'équipe de formation.");
		
		sender.send(message);
		
		return "E-Mail envoyé !";
	}

}
