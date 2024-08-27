 
package claseHijos;

import interfaces.Vuelo;
import clasePadre.Transporte;

public class Helicoptero extends Transporte implements Vuelo {
	
    public Helicoptero(int capacidad) {
        super(capacidad);
    }
	
	public String mostrarCapacidad() {
		return "Capacidad de pasajeros del Helicóptero :  " + capacidad;
	}
	
	public String avanzar() {
		return "el helicóptero está avanzando";
	}
	
	public String detener() {
		return "el helicóptero se detuvo";
	}	
	
	public String retroceder() {
		return "el helicóptero está retrocediendo";
	}
	
	public String subir() {
		return "el helicóptero está subiendo";
	}
	
	public String bajar() {
		return "el helicóptero está bajando";
	}			
}
