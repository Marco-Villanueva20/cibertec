package com.cibertec.contacto.interfaceService;

import java.util.List;
import java.util.Optional;

import com.cibertec.contacto.model.Contacto;

public interface IContactoService {

	public List<Contacto> listar();
	public Optional<Contacto> listarId(int id);
	public int guardar(Contacto c);
	public void eliminar(int id);
}
