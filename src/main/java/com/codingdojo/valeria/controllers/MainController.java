package com.codingdojo.valeria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.valeria.models.Person;
import com.codingdojo.valeria.services.ProjectService;

@Controller
public class MainController {
	
	@Autowired
	private ProjectService service;
	
	@GetMapping("/")
	public String index(@ModelAttribute("person") Person person) {
		return "index.jsp";
	}
	
	@PostMapping("/person/create")
	public String savePerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		service.savePerson(person);
		return "redirect:/";
	}
}
