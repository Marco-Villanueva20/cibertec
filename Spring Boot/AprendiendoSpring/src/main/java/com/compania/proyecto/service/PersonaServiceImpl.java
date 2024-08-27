package com.compania.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.compania.proyecto.repository.IPersonaRepo;
//import com.compania.proyecto.repository.PersonaRepoImpl;

@Service
public class PersonaServiceImpl implements IPersonaService{
	@Autowired
	@Qualifier("Persona1")
	private IPersonaRepo repo;
	@Override
	public void registrar(String nombre) {
		//repo=new PersonaRepoImpl();
		repo.registrar(nombre);
	}

}
