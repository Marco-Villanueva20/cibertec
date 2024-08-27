/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_14_Teo
	Project		:	Herencia_4
	File		:	Padre
	Renisión	:	15/01/2014
 */

package clasePadre;

public abstract class Padre {
	//  Atributos
	public int     v1;	// se hereda
	private int    v2;	// no se hereda
	protected int  v3;	// se hereda

	//  Constructor
	public Padre(int v1, int v2, int v3) {	// no se hereda
		this.v1 = v1;
	    this.v2 = v2;
	   	this.v3 = v3;
	}

	//  Métodos de acceso
	public int getv2() { // se hereda
		return v2;
	}

	public int getv3() { // se hereda
		return v3;
	}

	//  Operaciones
	public int suma() { // se hereda
		return v1 + v2 + v3;
	}

	public int producto() { // se hereda
		return v1 * v2 * v3;
	}
}
