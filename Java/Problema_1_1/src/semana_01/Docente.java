package semana_01;

public class Docente {
	//atributos	
	public int codigo;
	public String nombre;
	public int horas;
	public double tarifas;
	//metodos
	public double sueldoBruto() {
		return horas * tarifas;
	}
	public double descuento() {
		if(sueldoBruto() < 4500)
			return sueldoBruto() * 0.12;
		else if(sueldoBruto() < 6500)
			return sueldoBruto() * 0.14;
		else 
			return sueldoBruto() * 0.16;
	}
	public double sueldoNeto() {
		return sueldoBruto() - descuento();
	}

}

