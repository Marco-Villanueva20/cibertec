/*
	Location	:	AED_2014_Teo
	Workspace	:	Semana_12_Teo
	Project		:	Herencia_1
	File		:	Hijo
	Revisión	:	23/06/2014
 */

package claseHijos;

import clasePadre.Padre;

public class Hijo extends Padre {
	//  Atributo público
	public int  v4;

	//  Constructor
	public Hijo(int v1, int v2, int v3, int v4) {
		super(v1,v2,v3);
		this.v4 = v4;
	}

	//  Operaciones
	public int suma() {
		return sumaPadre() + v4;
	}

	public int producto() {
		return productoPadre() * v4;
	}
}
