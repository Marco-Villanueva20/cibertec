/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_4
	File		:	Circulo
	Revisión	:	22/01/2014
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
