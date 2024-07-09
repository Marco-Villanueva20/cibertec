package clase;

public class Alumno {
	
	//  Atributos privados
	private int codigo, nota1, nota2;
	private String nombre;	
	//  Constructor
    public Alumno(int codigo, String nombre, int nota1, int nota2) {
    	this.codigo = codigo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
	//  Métodos de acceso público: set/get
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
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