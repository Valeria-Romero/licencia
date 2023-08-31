package com.codingdojo.valeria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.valeria.models.Person;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long>{

}
