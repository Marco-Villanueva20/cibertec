 
package claseHijos;

import interfaces.Vuelo;
import clasePadre.Transporte;

public class Avion extends Transporte implements Vuelo {
	
    public Avion(int capacidad) {
        super(capacidad);
    }
	
	public String mostrarCapacidad() {
		return "Capacidad de pasajeros del Avión :  " + capacidad;
	}
	
	public String avanzar() {
		return "la avión está avanzando";
	}
	
	public String detener() {
		return "la avión se detuvo";
	}	
	
	public String retroceder() {
		return "la avión está retrocediendo";
	}
	
	public String subir() {
		return "la avión está subiendo";
	}
	
	public String bajar() {
		return "la avión está bajando";
	}			
}
