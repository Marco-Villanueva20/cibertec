/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_2
	File		:	Figura
	Revisi�n	:	22/01/2014
 */

package clasePadre;

public abstract class Figura {
	//  Atributos
	protected int x, y;
	
	//  Constructor
 	public Figura(int x, int y) {
		this.x = x;
		this.y = y;
   	}

	//  M�todo de operaci�n
  	public String ubicacion() {
      	return "(" + x + "," + y + ")";
   	}

	//  M�todos abstractos
	public abstract double area();

	public abstract String datosCompletos();
}

