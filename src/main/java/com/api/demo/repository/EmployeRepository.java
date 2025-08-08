package com.api.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.demo.model.Employe;

@Repository // indique que la classe est un bean et doit communiquer avec la base de donnée.
public interface EmployeRepository extends CrudRepository<Employe, Long> {

}
