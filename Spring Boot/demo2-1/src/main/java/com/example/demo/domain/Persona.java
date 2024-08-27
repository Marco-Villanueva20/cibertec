package com.example.demo.domain;

public class Persona {
	private String nombre;
	private String apellido;
	private String distrito;
	private String telefono;
	
	public Persona() {
	}
	public Persona(String nombre, String apellido, String distrito, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.distrito = distrito;
		this.telefono = telefono;
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
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", distrito=" + distrito + ", telefono="
				+ telefono + "]";
	}

	
}
