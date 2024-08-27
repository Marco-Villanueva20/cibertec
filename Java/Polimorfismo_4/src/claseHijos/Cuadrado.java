/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_4
	File		:	Cuadrado
	Revisión	:	22/01/2014
 */

package claseHijos;

import clasePadre.Figura;

public class Cuadrado extends Figura {
	//  Atributo
	private double lado;

	//  Constructor
	public Cuadrado(int x, int y, double lado) {
		super(x, y);
		this.lado = lado;
	}

	//  Método sobre escrito (obligatorio)
	public double area() {
		return lado * lado;
	}
}

