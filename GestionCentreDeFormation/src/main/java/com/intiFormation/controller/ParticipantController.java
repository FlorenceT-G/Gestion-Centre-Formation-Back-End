package com.intiFormation.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiFormation.entity.Formation;
import com.intiFormation.entity.Participant;
import com.intiFormation.entity.Prospect;
import com.intiFormation.service.IFormationService;
import com.intiFormation.service.IParticipantService;
import com.intiFormation.service.IProspectService;
import com.intiFormation.service.IRoleService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
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
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.clipper.Path;

@RestController
@RequestMapping("/assistant")
@CrossOrigin(origins = "http://localhost:4200")
public class ParticipantController {

	@Autowired
	IParticipantService IpService;
	@Autowired
	IProspectService prospectService;
	@Autowired
	IFormationService formationService;
	@Autowired
	BCryptPasswordEncoder bc;

	@Autowired
	IRoleService roleService;

	@PostMapping("/participantsparprospect")
	public Integer inserer(@RequestBody Prospect p) {
		Participant participant = new Participant();

		participant.setNom(p.getNom());
		participant.setPrenom(p.getPrenom());

		String username = p.getPrenom().substring(0, 1) + p.getNom().trim();
		username = username.replace(" ", "");
		participant.setUsername(username.toLowerCase());
		participant.setAdresseMail(p.getEmail());

		participant.setPassword(bc.encode("1234"));
		participant.setRole(roleService.checherById(5).get());
		IpService.Ajouter(participant);

		prospectService.supprimer(p.getIdProspect());

		return participant.getIdUtilisateur();
	}

	@PostMapping("/participants")
	public void insererParticipant(@RequestBody Participant p) {
		IpService.Ajouter(p);
	}

	@GetMapping("/participants")
	public List<Participant> aff() {
		List<Participant> Liste = IpService.GetAll();
		return (Liste);
	}

	@GetMapping("/participants/{id}")
	public Participant selectid(@PathVariable("id") int id) {
		Participant p = IpService.selectById(id);
		return (p);
	}

	@DeleteMapping("/participants/{id}")
	public void supp(@PathVariable("id") int id) {
		IpService.supprimer(id);
	}

	@PutMapping("/participants")
	public void update(@RequestBody Participant p) {
		IpService.Modifier(p);
	}

	@GetMapping("/participants-paiementsNok")
	public List<Participant> afficherParticipantByPaiementNok() {
		return IpService.chercherByPaiementNok();
	}

	/***
	 * Avec itextpdf
	 ***/
	@RequestMapping("/participant/diplome/{idParticipant}/{idFormation}")
	public String pdf(@PathVariable("idParticipant") int idParticipant, @PathVariable("idFormation") int idFormation) {
		Formation f = formationService.selectById(idFormation).get();
		Participant p = IpService.selectById(idParticipant);

		String pdfName = p.getNom() + p.getPrenom() + f.getLibFormation().replaceAll(" ", "") + ".pdf";
		
		// chemin d'accès de l'image
		java.nio.file.Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		java.nio.file.Path path = Paths.get(root.toString(), "src", "main", "resources", "img", "laureat.png");

		// document format paysage
		Document doc = new Document(PageSize.A4.rotate());
		try {
			PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(pdfName));

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

			Paragraph p3 = new Paragraph("pour en jouir avec les droits et les prérogatives qui y sont attachées", font2);
			p3.setAlignment(alignR);

			doc.add(p3);
			
			Paragraph signature = new Paragraph("\n\nSignature du titulaire : ", font2);
			doc.add(signature);

			doc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "PDF créé";
	}

}
