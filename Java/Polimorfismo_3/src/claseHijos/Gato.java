/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_15_Teo
	Project		:	Polimorfismo_3
	File		:	Gato
	Revisión	:	22/01/2014
 */

package claseHijos;

import clasePadre.Mamifero;

public class Gato extends Mamifero {

	public String mensaje() {
		return "soy gato";
	}

	public String hacerRuido() {
		return "miau";
	}
}
