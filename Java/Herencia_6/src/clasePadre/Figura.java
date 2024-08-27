/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_14_Teo
	Project		:	Herencia_5
	File		:	Figura
	Revisión	:	15/01/2014
 */

package clasePadre;

public abstract class Figura {
	//  Atributos
	protected int x;
 	protected int y;

	//  Constructor
 	public Figura(int x, int y) {
		this.x = x;
		this.y = y;
   	}

	//  Método
  	public String ubicacion() {
      	return "(" + x + "," + y + ")";
   	}

	//  Método abstracto
	public abstract double area();
}

