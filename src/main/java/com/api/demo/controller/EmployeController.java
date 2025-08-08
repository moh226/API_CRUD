package com.api.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.model.Employe;
import com.api.demo.service.EmployeService;

@RestController
public class EmployeController {
	
	@Autowired
	private EmployeService employeService; // injection d'une instance ou un objet employeService de type service dans cette classe.
	
	// créer ou ajouter un employé
	
	@PostMapping("/employe")
	public Employe createEmploye(@RequestBody Employe employe) {
		return employeService.saveEmploye(employe); 
	
	}
	
	// lire ou obtenir un seul employer via son id(PK)
	@GetMapping("/employe/{id}")
	public Employe getEmploye(@PathVariable("id") final Long id) {
		Optional<Employe> employe = employeService.getEmploye(id); 
		if(employe.isPresent()) {
			return employe.get(); 
		}else {
			return null; 
		}
	}
	
	// lire ou recuperer tout les employés
	
	@GetMapping("/employe") 
	public Iterable<Employe> getEmploye(){
		return employeService.getEmploye();  
	}
	
	@PutMapping("/employe/{id}")
	public Employe updateEmploye(@PathVariable("id") final Long id, @RequestBody Employe employe) {
		Optional<Employe> e = employeService.getEmploye(id);
		if(e.isPresent()) {
			Employe currentEmploye = e.get();
			
			String firstName = employe.getFirstName();
			if(firstName != null) {
				currentEmploye.setFirstName(firstName);
			}
			
			String lastName = employe.getLastName();
			if(lastName != null) {
				currentEmploye.setLastName(lastName);
			}
			
			String mail = employe.getMail();
			if(mail != null) {
				currentEmploye.setMail(mail);
			}
			
			String password = employe.getPassword();
			if(password != null) {
				currentEmploye.setPassword(password);
			}
			
			employeService.saveEmploye(currentEmploye);
			return currentEmploye; 
		}else {
			return null; 
		}
	}

}
