package semana_01;

public class Persona {
	//ATRIBUTOS
	public String nombre;
	public String apellido;
	public int edad;
	public double estatura;
	public double peso;
	//METODOS
	public String estado() {
		if(edad >= 18)
			return "Mayor de edad";
		else
			return "Menor de edad";
	}
	public double imc() {
		return peso/(estatura * estatura);
	}
}
