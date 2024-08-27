package com.example.demo;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.Persona;

@Controller
public class ControllerInicio {

	
	
	@GetMapping("/cibertec")
	public String inicio(Model model){
		var mensaje = "Hola a Todos";
		model.addAttribute("mensaje",mensaje);
		return "index";
	}
	@GetMapping("/user")
	public String usuario(Model model){
		var mensaje = "Hola a Todos";
		model.addAttribute("mensaje",mensaje);
		Persona persona1 = new Persona();
		persona1.setNombre("Mario");
		persona1.setApellido("Gracia");
		persona1.setDistrito("Surco");
		persona1.setTelefono("908765421");
		
		model.addAttribute("persona1",persona1);

		return "usuario";
	}
	@GetMapping("/lista")
	public String lista(Model model){
		var mensaje = "Hola a Todos";
		model.addAttribute("mensaje",mensaje);
		Persona persona1 = new Persona();
		persona1.setNombre("Mario");
		persona1.setApellido("Gracia");
		persona1.setDistrito("Surco");
		persona1.setTelefono("908765421");
		
		Persona persona2 = new Persona();
		persona2.setNombre("Maria");
		persona2.setApellido("Britney");
		persona2.setDistrito("Ancon");
		persona2.setTelefono("908335421");
		
		Persona persona3 = new Persona();
		persona3.setNombre("Jose");
		persona3.setApellido("Bringas");
		persona3.setDistrito("Ancon");
		persona3.setTelefono("902225421");
		
		var personas = Arrays.asList(persona1,persona2,persona3);
		//model.addAttribute("persona1",persona1);
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("personas",personas);
		return "reporte";
	}
}
