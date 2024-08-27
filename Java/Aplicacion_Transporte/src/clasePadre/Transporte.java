 
package clasePadre;

import interfaces.Movimiento;

public abstract class Transporte implements Movimiento {
	protected int  capacidad;
	
    public Transporte(int capacidad) {
        this.capacidad = capacidad;
    }
	
	public abstract String mostrarCapacidad();
	
	public String avanzar() {
		return "no hay mensaje";
	}
	
	public String detener() {
		return "no hay mensaje";
	}
	
	public String retroceder() {
		return "no hay mensaje";
	}	
}
