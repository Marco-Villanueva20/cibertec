/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_16_Teo
	Project		:	Interfaz_2
	File		:	Cuadrado
	Revisión	:	29/01/2014
 */

package claseHijos;

import clasePadre.Figura;
import interfaces.Dibujable;

public class Cuadrado extends Figura implements Dibujable {
	//  Atributo
	private double lado;

	//  Constructor
	public Cuadrado(int x, int y, double lado) {
		super(x, y);
		this.lado = lado;
	}

	//  Métodos sobre escritos (obligatorio)
	public double area() {
		return lado * lado;
	}
	
	public String dibujar() {
		return "el cuadrado puede ser dibujado";
	}	
}
