package com.ejemplo.proySpring3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {
	@Value("${index.saludo}")
	private String saludo;
	@GetMapping("/")
	public String Inicio(Model model) {
		var mensaje = "Hola Mundo con Thymeleaf";
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("saludo", saludo);
		return "index";
		
	}
}
