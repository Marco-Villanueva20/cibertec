package com.compania.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compania.proyecto.model.Persona;

public interface IPersonaRepository extends JpaRepository<Persona,Integer>{
	
}
