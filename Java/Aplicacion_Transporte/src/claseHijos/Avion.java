 
package claseHijos;

import interfaces.Vuelo;
import clasePadre.Transporte;

public class Avion extends Transporte implements Vuelo {
	
    public Avion(int capacidad) {
        super(capacidad);
    }
	
	public String mostrarCapacidad() {
		return "Capacidad de pasajeros del Avi�n :  " + capacidad;
	}
	
	public String avanzar() {
		return "la avi�n est� avanzando";
	}
	
	public String detener() {
		return "la avi�n se detuvo";
	}	
	
	public String retroceder() {
		return "la avi�n est� retrocediendo";
	}
	
	public String subir() {
		return "la avi�n est� subiendo";
	}
	
	public String bajar() {
		return "la avi�n est� bajando";
	}			
}
