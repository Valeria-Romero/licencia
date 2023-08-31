package com.codingdojo.valeria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.valeria.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	
}
