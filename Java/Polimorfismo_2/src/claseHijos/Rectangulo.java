/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_2
	File		:	Rectangulo
	Revisión	:	22/01/2014
 */

package claseHijos;

import clasePadre.Figura;

public class Rectangulo extends Figura {
	//  Atributo	
	private double  ancho, alto;

	//  Constructor
    public Rectangulo(int x, int y, double ancho, double alto) {
        super(x,y);
        this.ancho = ancho;
        this.alto = alto;
    }

	//  Métodos sobre escritos (obligatorio)
    public double area() {
        return ancho * alto;
    }

    public String datosCompletos() {
		return  "ubicación :  " + ubicacion() + "\n" +
		        "ancho     :  " + ancho + "\n" +
			    "alto      :  " + alto + "\n" +
			    "área      :  " + area() + "\n";
	}
}
