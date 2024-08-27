package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidad.Estudiante;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

	
}
