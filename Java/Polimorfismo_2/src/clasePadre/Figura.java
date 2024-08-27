/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_2
	File		:	Figura
	Revisión	:	22/01/2014
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

	//  Método de operación
  	public String ubicacion() {
      	return "(" + x + "," + y + ")";
   	}

	//  Métodos abstractos
	public abstract double area();

	public abstract String datosCompletos();
}

