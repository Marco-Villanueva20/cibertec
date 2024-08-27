/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_2
	File		:	Circulo
	Revisi�n	:	22/01/2014
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

	//  M�todos sobre escritos (obligatorio)
	public double area() {
		return Math.PI * radio * radio;
	}

    public String datosCompletos() {
		return  "ubicaci�n :  " + ubicacion() + "\n" +
		        "radio     :  " + radio + "\n" +
			    "�rea      :  " + area() + "\n";
	}
}
