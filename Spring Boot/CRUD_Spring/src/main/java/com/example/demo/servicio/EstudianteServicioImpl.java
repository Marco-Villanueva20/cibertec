package com.example.demo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Estudiante;
import com.example.demo.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio{

	@Autowired
	private EstudianteRepositorio repositorio;
	@Override
	public List<Estudiante> listarTodosLosEstudiantes() {
		return  repositorio.findAll();
	}
	
	

}
