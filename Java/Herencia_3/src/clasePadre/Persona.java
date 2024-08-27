/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_14_Teo
	Project		:	_Ejercicio
	File		:	Persona
	Revisión	:	15/01/2014
 */

package clasePadre;

public abstract class Persona {
	//  Atributos protegidos
	protected String  dni, nombre, apellido, fechaNacimiento,  direccion;
	protected int     edad;

	//  Constructor
	public Persona(String dni,String nombre, String apellido, String fechaNacimiento, String direccion, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento=fechaNacimiento;
		this.direccion=direccion;
		this.edad = edad;
	}

	//  Operaciones
	public String generarCorreo() {
		return nombre + "." + apellido + "@cibertec.edu.pe";
	}

	public String datosDeLaPersona() {
		return  "DNI   :  " + dni + "\n" +
				"Nombre   :  " + nombre + "\n" +
		        "Apellido :  " + apellido + "\n" +
		        "Fecha Nac:  " + fechaNacimiento + "\n" +
		        "Edad     :  " + edad+ "\n" +
		        "Direccion:  " + direccion;
	}

	public abstract String datosCompletos();
}
