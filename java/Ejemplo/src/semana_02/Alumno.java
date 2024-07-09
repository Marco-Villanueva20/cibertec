package semana_02;

public class Alumno {
	
	//  Atributos privados
	private int codigo, nota1, nota2;
	private String nombre;
	//  Constructor
	public Alumno(int cod, String nom, int n1, int n2) {
		codigo = cod;
		nombre = nom;
		nota1 = n1;
		nota2 = n2;
	}
	//  Métodos de acceso público: set/get
	public void setCodigo(int cod) {
		codigo = cod;
	}
	public void setNombre(String nom) {
		nombre = nom;
	}
	public void setNota1(int n1) {
		nota1 = n1;
	}
	public void setNota2(int n2) {
		nota2 = n2;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getNota1() {
		return nota1;
	}
	public int getNota2() {
		return nota2;
	}	    		
	//  Operaciones públicas
	public double promedio() {
		return (nota1 + nota2) / 2.0;
	}
	
}