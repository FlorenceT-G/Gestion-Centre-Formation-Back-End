package com.intiFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Paiement;
import com.intiFormation.entity.Participant;
import com.intiFormation.service.FormationService;
import com.intiFormation.service.PaiementService;
import com.intiFormation.service.ParticipantService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/assistant")
public class MailController {
	
	@Autowired
	public JavaMailSender sender;
	@Autowired
	ParticipantService pService;
	@Autowired
	FormationService fService;
	@Autowired
	PaiementService pyService;
	
	@ResponseBody
	@RequestMapping("/sendmail/{idParticipant}/{idFormation}")
	public String envoieMail(@PathVariable("idParticipant") int idParticipant, @PathVariable("idFormation") int idFormation) {
		
		Participant p = pService.selectById(idParticipant);
		Formation f = fService.selectById(idFormation).get();
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(p.getAdresseMail());
		message.setSubject("Inscription à la formation " + f.getLibFormation());
		message.setText("Bonjour " + p.getNom() + " " + p.getPrenom() 
		+ ", \nMerci de votre inscription à la formation " + f.getLibFormation()
		+ ".\nPour plus de détail rendez-vous sur votre compte !"
		+ "\n\nCordialement,\nL'équipe de formation.");
		
		sender.send(message);
		
		return "E-Mail envoyé !";
	}
	
	@ResponseBody
	@RequestMapping("/sendmailinscription/{idParticipant}")
	public void mailInscription(@PathVariable("idParticipant") int idParticipant) {
		Participant p = pService.selectById(idParticipant);
		
		SimpleMailMessage mssg = new SimpleMailMessage();
		mssg.setTo(p.getAdresseMail());
		mssg.setSubject("Inscription au Centre de Formation");
		mssg.setText("Bonjour " + p.getNom() + " " + p.getPrenom() 
		+ ", \nVeuillez trouver ci-dessous vos accès à la plateforme du centre de formation :"
		+ "\nIdentifiant : " + p.getUsername()
		+ "\nMot de passe : 1234"
		+ "\n\nCordialement,\nL'équipe de formation.");
		
		sender.send(mssg);
	}
	
	@ResponseBody
	@RequestMapping("/mailrelance/{idParticipant}/{idFormation}/{idPaiement}")
	public void mailRelance(@PathVariable("idParticipant") int idParticipant, @PathVariable("idFormation") int idFormation, @PathVariable("idPaiement") int idPaiement) {
		Participant p = pService.selectById(idParticipant);
		Formation f = fService.selectById(idFormation).get();
		Paiement py = pyService.selectById(idPaiement);
		
		SimpleMailMessage mssg = new SimpleMailMessage();
		mssg.setTo(p.getAdresseMail());
		mssg.setSubject("Relance paiement");
		mssg.setText("Bonjour " + p.getNom() + " " + p.getPrenom() 
		+ ", \nVous vous êtes récemment"
		+ "\n\nCordialement,\nL'équipe de formation.");
		
		sender.send(mssg);
	}

}
