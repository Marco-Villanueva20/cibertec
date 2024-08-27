package examen;

public class Auto {
	//ATRIBUTOS
	private String placa;
	private double precioPorKilometro;
	private int kilometrosRecorridos;
	//
	private static int  cantidad;
	private static double costoConsumo;
	//
	public static final double PDES;
	static {
		PDES = 0.05;
		cantidad = 0;
		costoConsumo = 0;
	}
	//Constructores
	public Auto(String placa, double precioPorKilometro, int kilometrosRecorridos) {
		this.placa = placa;
		this.precioPorKilometro = precioPorKilometro;
		this.kilometrosRecorridos = kilometrosRecorridos;
		cantidad ++;
		costoConsumo+=costoConsumo();
	}
	public Auto(String placa, double precioPorKilometros) {
		this(placa,precioPorKilometros,5);		
	}
	public Auto() {
		this("Ninguno",0.00,0);		
	}
	//set variables de clase
	public static void setCantidad(int cantidad) {
    	Auto.cantidad=cantidad;
    }
	public static void setCostoConsumo(double costoConsumo) {
    	Auto.costoConsumo=costoConsumo;
    }
	//get variables de clase
	public static int getCantidad() {
    	return Auto.cantidad;
    }
	public static double getCostoConsumo() {
    	return Auto.costoConsumo;
    }
	//set atributos
	public void setPlaca(String placa) {
    	this.placa = placa;
    }
	public void setPrecioPorKilometro(double precioPorKilometro) {
    	this.precioPorKilometro = precioPorKilometro;
    }
	public void setKilometrosRecorridos(int kilometrosRecorridos) {
    	this.kilometrosRecorridos = kilometrosRecorridos;
    }
	//get atributos
	public String getPlaca() {
    	return this.placa;
    }
	public double getPrecioPorKilometro() {
    	return this.precioPorKilometro;
    }
	public int getKilometrosRecorridos() {
    	return this.kilometrosRecorridos;
    }
	
	 public double costoConsumo() {
	    	return precioPorKilometro * kilometrosRecorridos;  			
	    }
	 public double descuento() {
	    	return PDES * costoConsumo();
	    }
	 public double totalPagar() {
	    	return costoConsumo() - descuento();  			
	    }
}
