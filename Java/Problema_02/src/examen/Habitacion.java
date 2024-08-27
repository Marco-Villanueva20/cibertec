package examen;

public class Habitacion {
	//ATRIBUTOS 
	private int numeroHabitacion;
	private double precioPorDia;
	private int diasDeHospedaje;
	//METODOS
	//variable que cuente la cantidad de objetos
	private static int cantidad;
	//variable que cuente el total a pagar
	private static double totalPagar;
	
	public static final double PORDES;
	static {
		PORDES = 0.04;
		cantidad= 0;
		totalPagar= 0;
	}
	//CONSTRUCTORES
	public Habitacion(int numeroHabitacion,double precioPorDia,int diasDeHospedaje) {
		this.numeroHabitacion = numeroHabitacion;
		this.precioPorDia =  precioPorDia;
		this.diasDeHospedaje = diasDeHospedaje;
		cantidad ++;
		totalPagar +=totalPagar();
	}
    public Habitacion(int numeroHabitacion,double precioPorDia) {
    	this(numeroHabitacion,precioPorDia,2);
    }
    public Habitacion() {
    	this(-1,0.0,0);
    }
    //SET atributos
    public void setNumeroHabitacion(int numeroHabitacion) {
    	this.numeroHabitacion = numeroHabitacion;
    }
    public void setPrecioPorDia(double precioPorDia) {
    	this.precioPorDia = precioPorDia;
    }
    public void setDiasDeHospedaje(int diasDeHospedaje) {
    	this.diasDeHospedaje = diasDeHospedaje;
    }
    //GET atributo
    public int getNumeroHabitacion() {
    	return this.numeroHabitacion;
    }
    public double getPrecioPorDia() {
    	return this.precioPorDia;
    }
    public int getDiasDeHospedaje() {
    	return this.diasDeHospedaje;
    }
    //variables de clase
    //set
    public static void setCantidad(int cantidad) {
    	Habitacion.cantidad=cantidad;
    }
    public static void setTotalPagar(double totalPagar) {
    	Habitacion.totalPagar = totalPagar;
    }
    //get
    public static int getCantidad() {
    	return Habitacion.cantidad;
    }
    public static double getTotalPagar() {
    	return Habitacion.totalPagar;
    }
    
    public double subTotal() {
    	return this.precioPorDia * this.diasDeHospedaje;
    }
    public double descuento() {
    	return PORDES * subTotal();
    }
    public double totalPagar() {
    	return subTotal() - descuento();  			
    }
    }


