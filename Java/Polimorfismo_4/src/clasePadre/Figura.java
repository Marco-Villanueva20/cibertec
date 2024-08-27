/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_4
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

	//  M�todo
  	public String ubicacion() {
      	return "(" + x + "," + y + ")";
   	}

	//  M�todo abstracto
	public abstract double area();
}
