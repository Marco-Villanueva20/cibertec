 
package claseHijos;

import clasePadre.Transporte;

public class Auto extends Transporte {
	
    public Auto(int capacidad) {
        super(capacidad);
    }
	
	public String mostrarCapacidad() {
		return "Capacidad de pasajeros del Auto :  " + capacidad;
	}
	
	public String avanzar() {
		return "el auto está avanzando";
	}	
}
