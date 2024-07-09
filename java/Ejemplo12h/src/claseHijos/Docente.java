/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_14_Teo
	Project		:	_Ejercicio
	File		:	Docente
	Revisión	:	15/01/2014
 */

package claseHijos;

import clasePadre.Persona;

public class Docente extends Persona {
	//  Atributos privados
	private int     horas;
	private double  tarifa;

	//  Constructor
	public Docente(String nombre, String apellido, int edad,
	               int horas, double tarifa) {
		super(nombre,apellido,edad);
		this.horas = horas;
		this.tarifa = tarifa;
	}

	//  Operaciones
	public double calcularSueldo() {
		return horas*tarifa;
	}

	public String datosCompletos() {
		return datosDeLaPersona() + "\n" +
		       "Horas    :  " + horas + "\n" +
		       "Tarifa   :  " + tarifa;
	}
}
