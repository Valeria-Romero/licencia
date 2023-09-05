package com.codingdojo.valeria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.valeria.models.License;
import com.codingdojo.valeria.models.Person;
import com.codingdojo.valeria.repositories.LicenseRepository;
import com.codingdojo.valeria.repositories.PersonRepository;

@Service
public class ProjectService {
	
	@Autowired
	private LicenseRepository lRepo;
	
	@Autowired
	private PersonRepository pRepo;
	
	public Person savePerson(Person person) {
		return pRepo.save(person);
	}
	
	public List<Person> LicenseNull(){
		return pRepo.findByLicenseIdIsNull();
	}
	
	public int newLicenseNumber() {
		License license = lRepo.findTopByOrderByNumberDesc();
		if(license == null) {
			return 1;
		}
		int maxNumber = license.getNumber();
		maxNumber++;
		return (maxNumber);
	}
	
	public License saveLicense(License license) {
		license.setNumber(this.newLicenseNumber());
		return lRepo.save(license);
	}
	
	public List<Person> findAll(){
		return pRepo.findAll();
	}
	
	public Person findPerson(Long id) {
		return pRepo.findById(id).orElse(null);
	}
}
