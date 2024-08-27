package com.cibertec.contacto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.contacto.interfaceService.IContactoService;
import com.cibertec.contacto.interfaces.IContacto;
import com.cibertec.contacto.model.Contacto;

@Service
public class ContactoService implements IContactoService {

	@Autowired
	private IContacto data;
	@Override
	public List<Contacto> listar() {
		return (List<Contacto>) data.findAll();
	}

	@Override
	public Optional<Contacto> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int guardar(Contacto c) {
		int res=0;
		Contacto contacto = data.save(c);
		if(contacto.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);	
	}

}
