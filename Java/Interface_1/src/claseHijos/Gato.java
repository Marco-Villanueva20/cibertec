/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_16_Teo
	Project		:	Interfaz_1
	File		:	Gato
	Revisión	:	29/01/2014
 */

package claseHijos;

import clasePadre.Mamifero;
import interfaces.InterfazA;

public class Gato extends Mamifero implements InterfazA {

	public String mensaje() {
		return "soy gato";
	}

	public String hacerRuido() {
		return "miau";
	}
	
	public String cuidado() {
		return "el gato puede tener rabia";
	}
}
