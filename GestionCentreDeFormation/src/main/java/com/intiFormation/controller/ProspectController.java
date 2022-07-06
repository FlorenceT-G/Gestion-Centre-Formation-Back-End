package com.intiFormation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intiFormation.entity.Prospect;
import com.intiFormation.service.IProspectService;


@RestController
@RequestMapping("/commercial")
@CrossOrigin(origins="http://localhost:4200")
public class ProspectController {
	
	@Autowired
	IProspectService IpService;
	
	@PostMapping("/prospects")
	public void inserer(@RequestBody Prospect prospect)
	{
		IpService.Ajouter(prospect);
	}

	@GetMapping("/prospects")
	public List<Prospect> aff()
	{
		List<Prospect> Liste=  IpService.GetAll();
		return (Liste);
	}
	
	@GetMapping("/prospects/{nom}")
	public List<Prospect> affnom(@PathVariable("id") String nom)
	{
		List<Prospect> Liste=  IpService.SelectByNom(nom);
		return (Liste);
	}
	
	@GetMapping("/prospects/{id}")
	public Prospect selectid(@PathVariable("id") int id)
	{
		Prospect p =  IpService.SelectById(id);
		return (p);
	}
	
	@GetMapping("/prospects/{num}")
	public Prospect selectnum(@PathVariable("num") long num)
	{
		Prospect p =  IpService.SelectByNum(num);
		return (p);
	}
	
	@GetMapping("/prospects/{mail}")
	public Prospect selectmail(@PathVariable("mail") String mail)
	{
		Prospect p =  IpService.SelectByEmail(mail);
		return (p);
	}
	
	@DeleteMapping ("/prospects/{id}")
	public void supp(@PathVariable("id") int id)
	{
		IpService.supprimer(id);
	}
	
	@PutMapping("/prospects")
	public void update(@RequestBody Prospect p)
	{
		IpService.Modifier(p);
	}
	
	@GetMapping("/csvFile")	
	public void csvReader(@RequestParam("file") MultipartFile file, HttpSession session) {
		String filename = file.getOriginalFilename();
		String path = "C:\\Users\\p.gaillard\\Downloads\\"+filename;
		
		// List<Prospect> prospects = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File(path)); //parsing a CSV file into the constructor of Scanner class 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Prtoposer à l'utilisateur d'utiliser son délimiteur
		
	    sc.useDelimiter(","); //setting comma as delimiter pattern

	    while (sc.hasNext()) {
	    	// String Tampon = sc.next();
	    	Prospect prospect = new Prospect();
	    	prospect.setNom(sc.next());
	    	prospect.setPrenom(sc.next());
	    	prospect.setEmail(sc.next());
	    	
	    	String SnumBrut = sc.next();
	    	String SnumTel = SnumBrut;
	    	if(SnumBrut.substring(0,1).equals("0")) {
	    		SnumTel = "33" + SnumBrut.substring(1);
	    	}
	    	long numTel = Long.parseLong(SnumTel);
	    	
	    	prospect.setNumTel(numTel);
	    	// prospects.add(prospect);
			IpService.Ajouter(prospect);
	    }
	    
	    // System.out.println(prospects);
	    sc.close();
	}

}