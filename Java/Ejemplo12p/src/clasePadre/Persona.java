/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	_Ejercicio
	File		:	Persona
	Revisión	:	22/01/2014
 */

package clasePadre;

public abstract class Persona {
	//  Atributos protegidos
	protected String  nombre, apellido;
	protected int     edad;

	//  Constructor
	public Persona(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	//  Operaciones
	public String generarCorreo() {
		return nombre + "." + apellido + "@cibertec.edu.pe";
	}

	public String datosDeLaPersona() {
		return "Nombre   :  " + nombre + "\n" +
		       "Apellido :  " + apellido + "\n" +
		       "Edad     :  " + edad + "\n";
	}

	//  Método abstracto
	public abstract String datosCompletos();
}
