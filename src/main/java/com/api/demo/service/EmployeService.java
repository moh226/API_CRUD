package com.api.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.demo.model.Employe;
import com.api.demo.repository.EmployeRepository;

import lombok.Data;

@Data
@Service
public class EmployeService {
	
	@Autowired
	private EmployeRepository employeRepository; // injection d'une instance de type Repository dans cette classe.
	
	public Optional<Employe> getEmploye(final Long id){
		return employeRepository.findById(id);
	}
	
	public Iterable<Employe> getEmploye(){
		return employeRepository.findAll();
	}
	
	public void deleteEmploye(final Long id) {
		employeRepository.deleteById(id);
	}
	
	public Employe saveEmploye(Employe employe) {
		Employe saveEmploye = employeRepository.save(employe);
		return saveEmploye; 
	}

}
