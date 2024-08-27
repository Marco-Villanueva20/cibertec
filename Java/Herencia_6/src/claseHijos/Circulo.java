/*
	Location	:	AED_2014_Teo
	Workspace	:	Semana_14_Teo
	Project		:	Herencia_5
	File		:	Circulo
	Revisión	:	15/01/2014
 */

package claseHijos;

import clasePadre.Figura;

public class Circulo extends Figura {
	//  Atributo
 	private double radio;

	//  Constructor
	public Circulo(int x, int y, double radio) {
		super(x, y);
		this.radio = radio;
	}

	//  Método sobre escrito (obligatorio)
	public double area() {
		return Math.PI * radio * radio;
	}
}
