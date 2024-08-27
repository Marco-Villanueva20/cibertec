package com.cibertec.contacto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.contacto.interfaceService.IContactoService;
import com.cibertec.contacto.model.Contacto;

@Controller
public class Controlador {
	@Autowired
	private IContactoService service;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Contacto> contactos = service.listar();
		model.addAttribute("contactos", contactos);
		return "index";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Contacto> contacto = service.listarId(id);
		model.addAttribute("contacto",contacto);
		return "form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		service.eliminar(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("contacto", new Contacto());
		return "form";
	}
	
	@PostMapping("/save")
	public String guardar(@Validated Contacto c, Model model) {
		service.guardar(c);
		return "redirect:/listar";
	}
}
