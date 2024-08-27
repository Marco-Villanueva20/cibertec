/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_14_Teo
	Project		:	Herencia_3
	File		:	Hijo
	Revisión	:	15/01/2014
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
		return super.suma() + v4;
	}

	public int producto() {
		return super.producto() * v4;
	}
}
