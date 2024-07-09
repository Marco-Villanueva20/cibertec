package com.compania.proyecto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.compania.proyecto.service.IPersonaService;
//import com.compania.proyecto.service.PersonaServiceImpl;

@SpringBootApplication
public class AprendiendoSpringApplication implements CommandLineRunner{
	private static Logger LOG = LoggerFactory.getLogger(AprendiendoSpringApplication.class);
	
	@Autowired
	private IPersonaService service;

	public static void main(String[] args) {
		SpringApplication.run(AprendiendoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Coders desde Spring Boot en consola");
		LOG.warn("Advirtiendote xd");
		//service = new PersonaServiceImpl();
		service.registrar("Marco Antonio");
	}

}
