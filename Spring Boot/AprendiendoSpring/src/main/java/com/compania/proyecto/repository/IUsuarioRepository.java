package com.compania.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compania.proyecto.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
	Usuario findByNombre(String nombre);
}
