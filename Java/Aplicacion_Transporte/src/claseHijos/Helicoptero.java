 
package claseHijos;

import interfaces.Vuelo;
import clasePadre.Transporte;

public class Helicoptero extends Transporte implements Vuelo {
	
    public Helicoptero(int capacidad) {
        super(capacidad);
    }
	
	public String mostrarCapacidad() {
		return "Capacidad de pasajeros del Helic�ptero :  " + capacidad;
	}
	
	public String avanzar() {
		return "el helic�ptero est� avanzando";
	}
	
	public String detener() {
		return "el helic�ptero se detuvo";
	}	
	
	public String retroceder() {
		return "el helic�ptero est� retrocediendo";
	}
	
	public String subir() {
		return "el helic�ptero est� subiendo";
	}
	
	public String bajar() {
		return "el helic�ptero est� bajando";
	}			
}
