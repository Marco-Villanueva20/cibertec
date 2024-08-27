package com.sistemas.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sistemas.demo.model.Persona;

public interface IPersonaService {
	public List<Persona>  listar();
	public Optional<Persona> listarId(int id);
	public int guardar(Persona p);
	
	public void eliminar(int id);
}
