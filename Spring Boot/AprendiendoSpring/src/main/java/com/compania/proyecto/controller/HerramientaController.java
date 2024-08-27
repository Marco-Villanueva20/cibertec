package com.compania.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.compania.proyecto.model.Persona;
import com.compania.proyecto.repository.IPersonaRepository;

@Controller
public class HerramientaController {
	@Autowired
	private IPersonaRepository repo;
	
	@GetMapping("/greeting")
	public String geeting(@RequestParam(name="name", required = false, defaultValue = "World")String name,Model model) {
		Persona p = new Persona();
		p.setIdPersona(2);
		p.setNombre("Roxana");
		repo.save(p);
		
		model.addAttribute("name",name);
		return "greeting";
	}
	
	@GetMapping("/listar")
	public String geeting(Model model) {
		//logica
		model.addAttribute("personas",repo.findAll());
		return "greeting";
	}
	
}
