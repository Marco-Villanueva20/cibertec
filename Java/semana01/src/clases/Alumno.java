package clases;

public class Alumno {
	//ATRIBUTOS
	public int codigo;
	public String nombre;
	public double nota1;
	public double nota2;
	//Metodos
	public double promedio(){
		return (nota1 + nota2)/2;
	}
} 
