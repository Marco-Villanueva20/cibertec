package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entidad.Estudiante;
import com.example.demo.repositorio.EstudianteRepositorio;

@SpringBootApplication
public class CrudSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}
	@Autowired
	private EstudianteRepositorio repositorio;
	@Override
	public void run(String... args) throws Exception {

	}

}
