package arreglo;

import clase.Alumno;

import java.util.ArrayList;

public class ArregloAlumnos {
	
	//  Atributo privado
	private ArrayList <Alumno> alu;
	//  Constructor
    public ArregloAlumnos() {
    	alu = new ArrayList <Alumno> ();
    	adicionar(new Alumno(123, "Ana", 19, 15));
    	adicionar(new Alumno(456, "Juan", 15, 14));
    	adicionar(new Alumno(789, "Pedro", 17, 19));
    	adicionar(new Alumno(302, "David", 13, 18));
    }
	//  Operaciones públicas básicas
	public void adicionar(Alumno x) {
		alu.add(x);
	}
	public int tamaño() {
		return alu.size();
	}
	public Alumno obtener(int i) {
		return alu.get(i);
	}
	//  Operaciones públicas complementarias
	public double promedioGeneral() {
    	double suma = 0.0;
    	for (int i=0; i<tamaño(); i++)
        	suma += obtener(i).promedio();
	    return suma / tamaño();
    }
	public double promedioMayor() {
	    double mayor = obtener(0).promedio();
	    for (int i=1; i<tamaño(); i++)
	        if (mayor < obtener(i).promedio())
	            mayor = obtener(i).promedio();
	    return mayor;
	}

}