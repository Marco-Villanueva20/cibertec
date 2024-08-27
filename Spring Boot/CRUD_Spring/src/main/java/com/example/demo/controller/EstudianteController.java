package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.servicio.EstudianteServicio;

@Controller
public class EstudianteController {
	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping("/")
	public String listarEstudiante(Model modelo) {
		modelo.addAttribute("estudiantes",servicio.listarTodosLosEstudiantes());
		return "estudiante";
	}
}
