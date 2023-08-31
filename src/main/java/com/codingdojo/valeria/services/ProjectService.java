package com.codingdojo.valeria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
