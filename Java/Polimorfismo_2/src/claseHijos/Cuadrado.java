/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_2
	File		:	Cuadrado
	Revisi�n	:	22/01/2014
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

	//  M�todos sobre escritos (obligatorio)
	public double area() {
		return lado * lado;
	}

    public String datosCompletos() {
		return  "ubicaci�n :  " + ubicacion() + "\n" +
		        "lado      :  " + lado + "\n" +
			    "�rea      :  " + area() + "\n";
	}
}

