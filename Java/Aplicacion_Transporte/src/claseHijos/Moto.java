 
package claseHijos;

import clasePadre.Transporte;

public class Moto extends Transporte {
	
    public Moto(int capacidad) {
        super(capacidad);
    }
	
	public String mostrarCapacidad() {
		return "Capacidad de pasajeros de la Moto :  " + capacidad;
	}
	
	public String avanzar() {
		return "la moto está avanzando";
	}
	
	public String detener() {
		return "la moto se detuvo";
	}	
	
	public String retroceder() {
		return "la moto está retrocediendo";
	}	
}
