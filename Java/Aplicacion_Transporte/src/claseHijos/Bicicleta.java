 
package claseHijos;

import clasePadre.Transporte;

public class Bicicleta extends Transporte {
	
    public Bicicleta(int capacidad) {
        super(capacidad);
    }
	
	public String mostrarCapacidad() {
		return "Capacidad de pasajeros de la Bicicleta :  " + capacidad;
	}
	
	public String avanzar() {
		return "la bicicleta está avanzando";
	}
	
	public String detener() {
		return "la bicicleta se detuvo";
	}	
}
