package arreglo;

import java.util.ArrayList;

import clase.Alumno;

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
    	adicionar(new Alumno(417, "Carlos", 20, 19));
    	adicionar(new Alumno(641, "Jorge", 12, 13));
    	adicionar(new Alumno(208, "María", 15, 17));
    	adicionar(new Alumno(820, "José", 11, 10));
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
	public int cantAprobados() {
    	return 0;
    }
}

