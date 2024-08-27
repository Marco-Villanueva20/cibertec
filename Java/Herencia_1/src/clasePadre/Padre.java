/*
	Location	:	AED_2014_Teo
	Workspace	:	Semana_12_Teo
	Project		:	Herencia_1
	File		:	Padre
	Renisión	:	23/06/2014
 */

package clasePadre;

public class Padre {
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
	public int sumaPadre() { // se hereda
		return v1 + v2 + v3;
	}

	public int productoPadre() { // se hereda
		return v1 * v2 * v3;
	}
}
