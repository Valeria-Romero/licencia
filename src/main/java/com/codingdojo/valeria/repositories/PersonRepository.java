package com.codingdojo.valeria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.valeria.models.Person;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long>{
	@Query(value="SELECT people.* FROM people LEFT OUTER JOIN licenses ON people.id = licenses.person_id WHERE licenses.id IS NULL;", nativeQuery=true)
	List<Person> findByNoLicense();
	
	List<Person> findByLicenseIdIsNull();
	
	List<Person> findAll();
}
