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
    	adicionar(new Alumno(417, "Carlos", 20, 19));
    	adicionar(new Alumno(641, "Jorge", 12, 13));
    	adicionar(new Alumno(208, "Mar�a", 15, 17));
    	adicionar(new Alumno(820, "Jos�", 11, 10));
    }
	//  Operaciones p�blicas b�sicas
	public void adicionar(Alumno x) {
		alu.add(x);
	}
    public int tama�o() {
		return alu.size();
	}
	public Alumno obtener(int i) {
		return alu.get(i);
	}
	public Alumno buscar(int codigo) {
		for (int i=0; i<tama�o(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
	}
	public void eliminar(Alumno x) {
		alu.remove(x);
	}
	
}