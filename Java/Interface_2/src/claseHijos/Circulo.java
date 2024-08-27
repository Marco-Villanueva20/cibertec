/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_16_Teo
	Project		:	Interfaz_2
	File		:	Circulo
	Revisión	:	29/01/2014
 */

package claseHijos;

import clasePadre.Figura;
import interfaces.*;

public class Circulo extends Figura implements Dibujable, Rotable {
	//  Atributo
 	private double radio;

	//  Constructor
	public Circulo(int x, int y, double radio) {
		super(x, y);
		this.radio = radio;
	}

	//  Métodos sobre escritos (obligatorio)
	public double area() {
		return Math.PI * radio * radio;
	}
	
	public String dibujar() {
		return "el círculo puede ser dibujado";
	}	
	
	public String rotar() {
		return "el círculo puede rotar";
	}	
}
