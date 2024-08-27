package com.cibertec.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int codigo;
	@Column(name = "nombre")
	public String nombre;
	@Column(name = "apellido")
	public String apellido;
	@Column(name = "dni")
	public String dni;
	@Column(name = "nroCelular")
	public String nroCelular;
	
	public Cliente() {
	}
	public Cliente(int codigo, String nombre, String apellido, String dni, String nroCelular) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.nroCelular = nroCelular;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNroCelular() {
		return nroCelular;
	}
	public void setNroCelular(String nroCelular) {
		this.nroCelular = nroCelular;
	}
	
	
}
