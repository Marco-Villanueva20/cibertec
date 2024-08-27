package com.compania.proyecto.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.compania.proyecto.AprendiendoSpringApplication;

@Repository
@Qualifier("Persona1")
public class PersonaRepoImpl1 implements IPersonaRepo {
	private static Logger LOG = LoggerFactory.getLogger(AprendiendoSpringApplication.class);
	@Override
	public void registrar(String nombre) {
		LOG.info("SE REGISTRO A "+nombre);

	}

}
