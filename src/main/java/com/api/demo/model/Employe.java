package com.api.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data // Null besoin de getter et setter
@Entity // indique que la classe correspond a une table de la base de donnée
@Table(name = "employees") // indique le nom de la table associée.
public class Employe {
	
	@Id // indique de l'id est la PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indique que l'id s'autiIncrement.
	private Long id;
	
	@Column(name = "first_name") // indique le nom de l'instace ou le champ de la table
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String mail;
	
	// pas besoin d'annotation @Column parceque le nom de l'instance de la table sera identique.
	private String password;

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) { 
		this.lastName = lastName; 
	}
	
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) { 
		this.mail = mail; 
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
