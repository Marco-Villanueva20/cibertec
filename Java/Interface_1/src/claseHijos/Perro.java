/*
	Location	:	AED_2013_Teo
	Workspace	:	Semana_16_Teo
	Project		:	Interfaz_1
	File		:	Perro
	Revisión	:	29/01/2014
 */

package claseHijos;

import clasePadre.Mamifero;
import interfaces.*;

public class Perro extends Mamifero implements InterfazA, InterfazB {

	public String hacerRuido() {
		return "guau";
	}
	
	public String cuidado() {
		return "el perro puede tener rabia";
	}
	
	public String peligro() {
		return "el perro muerde";
	}		
}
