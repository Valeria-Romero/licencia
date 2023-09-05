package com.codingdojo.valeria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.valeria.models.License;
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
	
	@GetMapping("/licenses/new")
	public String licenseForm(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("people", service.LicenseNull());
		return "newLicense.jsp";
	}
	
	@PostMapping("/license/create")
	public String saveLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "newLicense.jsp";
		}
		service.saveLicense(license);
		return "redirect:/";
	}
	
	@GetMapping("/person/list")
	public String showList(Model model) {
		model.addAttribute("list", service.findAll());
		return "infoLicencia.jsp";
	}
	
	@GetMapping("/view/{id}")
	public String showPerson(@PathVariable("id")Long id, Model model) {
		model.addAttribute("person", service.findPerson(id));
		return "infoPerson.jsp";
	}
	
}
