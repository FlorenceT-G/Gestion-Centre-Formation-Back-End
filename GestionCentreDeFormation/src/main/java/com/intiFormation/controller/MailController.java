package com.intiFormation.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Paiement;
import com.intiFormation.entity.Participant;
import com.intiFormation.mailConfig.MailConstants;
import com.intiFormation.service.FormationService;
import com.intiFormation.service.PaiementService;
import com.intiFormation.service.ParticipantService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
@CrossOrigin("http://localhost:4200")
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
	@RequestMapping("/assistant/sendmail/{idParticipant}/{idFormation}")
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
	@RequestMapping("/assistant/sendmailinscription/{idParticipant}")
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
	@RequestMapping("/assistant/mailrelance/{idParticipant}/{idFormation}")
	public void mailRelance(@PathVariable("idParticipant") int idParticipant, @PathVariable("idFormation") int idFormation) {
		
		System.out.println("envoie mail relance");
		
		Participant p = pService.selectById(idParticipant);
		Formation f = fService.selectById(idFormation).get();
		List<Paiement> lpy = pyService.selectByParticipant(idParticipant);
		
		List<Paiement> lPaiementsFormation = new ArrayList<Paiement>();
		
		for(Paiement paiement : lpy) {
			if(paiement.getFormation().getIdFormation() == idFormation) {
				lPaiementsFormation.add(paiement);
			}
		}
		
		// récupère la dernière transaction et le montant restant
		Paiement paiementFormationEnCours = lPaiementsFormation.stream().max(Comparator.comparingInt(Paiement::getIdPaiement)).get();
		
		SimpleMailMessage mssg = new SimpleMailMessage();
		mssg.setTo(p.getAdresseMail());
		mssg.setSubject("Relance paiement");
		mssg.setText("Bonjour " + p.getNom() + " " + p.getPrenom() 
		+ ", \nIl vous reste actuellement " + paiementFormationEnCours.getReste() + "€ pour la formation : " + f.getLibFormation()
		+ ".\nMerci de vous rendre sur votre compte de formation afin de procéder au paiement."
		+ "\n\nCordialement,\nL'équipe de formation.");
		
		sender.send(mssg);
	}
	
	public void writePDF(ByteArrayOutputStream outputStream, int idParticipant, int idFormation) {
		Formation f = fService.selectById(idFormation).get();
		Participant p = pService.selectById(idParticipant);

		// chemin d'accès de l'image
		java.nio.file.Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		java.nio.file.Path path = Paths.get(root.toString(), "src", "main", "resources", "img", "laureat.png");

		Document doc = new Document(PageSize.A4.rotate());

		try {
			PdfWriter writer = PdfWriter.getInstance(doc, outputStream);

			doc.open();

			PdfContentByte canvas = writer.getDirectContent();
			Rectangle rec = new Rectangle(10, 10, 832, 586);

			rec.setBorder(rec.BOX);
			rec.setBorderWidth(1);
			rec.setBorderColor(BaseColor.YELLOW);
			canvas.rectangle(rec);

			int alignmentV = Element.ALIGN_CENTER;
			int alignR = Element.ALIGN_RIGHT;

			Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, BaseColor.DARK_GRAY);
			Paragraph centre = new Paragraph("CENTRE DE GESTION DE FORMATIONS");

			centre.setAlignment(alignmentV);

			doc.add(centre);

			font = FontFactory.getFont(FontFactory.TIMES_BOLD, 30, BaseColor.BLACK);
			Paragraph d = new Paragraph("CERTIFICAT \n" + f.getLibFormation().toUpperCase() + "\n", font);

			d.setAlignment(alignmentV);
			doc.add(d);

			try {
				Image img = Image.getInstance(path.toAbsolutePath().toString());

				img.scalePercent(10);
				img.setAlignment(alignmentV);

				doc.add(img);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Font font2 = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.BLACK);
			Paragraph p1 = new Paragraph("Vu le procès verbal de l'examen le " + f.getDateFin()
					+ ", \npar le formateur certifié " + f.getFormateur().getNom() + ", " + f.getFormateur().getPrenom()
					+ "\nLe certificat de formation " + f.getLibFormation() + "\nest conféré à ", font2);

			doc.add(p1);

			Font font3 = FontFactory.getFont(FontFactory.TIMES_BOLD, 14, BaseColor.BLUE);
			Paragraph p2 = new Paragraph(p.getPrenom() + " " + p.getNom() + "\n", font3);

			doc.add(p2);

			Paragraph p3 = new Paragraph("pour en jouir avec les droits et les prérogatives qui y sont attachées",
					font2);
			p3.setAlignment(alignR);

			doc.add(p3);

			Paragraph signature = new Paragraph("\n\nSignature du titulaire : ", font2);
			doc.add(signature);

			doc.close();

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping("/participant/send-diplome-mail/{idParticipant}/{idFormation}")
	public void sendDiploma(@PathVariable("idParticipant") int idParticipant,
			@PathVariable("idFormation") int idFormation) {
		
		// références utilisées :
		// https://javakapil.wordpress.com/2011/09/14/how-to-send-pdf-via-email-generated-from-itext/
		// https://www.baeldung.com/spring-email

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailConstants.MY_EMAIL, MailConstants.MY_PASSWORD);
			}
		});

		Participant p = pService.selectById(idParticipant);
		Formation f = fService.selectById(idFormation).get();

		ByteArrayOutputStream outputStream = null;

		try {

			// construction du corps de message
			MimeBodyPart textbody = new MimeBodyPart();
			textbody.setText("Bonjour " + p.getPrenom()
					+ "\n\nVous trouverez en P.J. votre certificat attestant de la complétion de votre formation "
					+ f.getLibFormation() + "\n\nCordialement,\nL'équipe de formation.");

			// écriture du pdf dans le output stream
			outputStream = new ByteArrayOutputStream();
			writePDF(outputStream, idParticipant, idFormation);
			byte[] bytes = outputStream.toByteArray();

			// construction du body part du pdf
			DataSource data = new ByteArrayDataSource(bytes, "application/pdf");
			MimeBodyPart pdfbodypart = new MimeBodyPart();
			pdfbodypart.setDataHandler(new DataHandler(data));
			pdfbodypart.setFileName(p.getNom() + p.getPrenom() + f.getLibFormation().replaceAll(" ", "") + ".pdf");

			// construction du mime multipart			
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textbody);
			multipart.addBodyPart(pdfbodypart);

			// create the sender/recipient addresses
			InternetAddress s = new InternetAddress(MailConstants.MY_EMAIL);
			InternetAddress r = new InternetAddress(p.getAdresseMail());

			// message
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setSender(s);
			mimeMessage.setSubject("Certificat de formation " + f.getLibFormation());
			mimeMessage.setRecipient(Message.RecipientType.TO, r);
			mimeMessage.setContent(multipart);

			// envoie
			Transport.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
