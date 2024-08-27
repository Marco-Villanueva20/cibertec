package com.sistemas.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemas.demo.interfaceService.IPersonaService;
import com.sistemas.demo.interfaces.IPersona;
import com.sistemas.demo.model.Persona;
@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		
		return (List<Persona>) data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return data.findById(id);
	}

	

	@Override
	public void eliminar(int id) {
		data.deleteById(id);

	}

	@Override
	public int guardar(Persona p) {
		int res = 0;
		Persona persona = data.save(p);
		if(persona.equals(null)) {
			res = 1;
		}
		return res;
	}

}
