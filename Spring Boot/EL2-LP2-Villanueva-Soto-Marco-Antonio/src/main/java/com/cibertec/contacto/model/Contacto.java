package com.cibertec.contacto.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Contacto")
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdContacto;
	private String Nombre;
	private String Celular;
	private String Email;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate FechaDeNacimiento;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime FechaDeRegistro;
	

	public Contacto() {
	}
	public Contacto(int idContacto, String nombre, String celular, String email, LocalDate fechaDeNacimiento,
			LocalDateTime fechaDeRegistro) {
		IdContacto = idContacto;
		Nombre = nombre;
		Celular = celular;
		Email = email;
		FechaDeNacimiento = fechaDeNacimiento;
		FechaDeRegistro = fechaDeRegistro;
	}
	public int getIdContacto() {
		return IdContacto;
	}
	public void setIdContacto(int idContacto) {
		IdContacto = idContacto;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public LocalDate getFechaDeNacimiento() {
		return FechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		FechaDeNacimiento = fechaDeNacimiento;
	}
	public LocalDateTime getFechaDeRegistro() {
		
		return FechaDeRegistro;
	}
	public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
		FechaDeRegistro = fechaDeRegistro;
	}
	
	
	
}
