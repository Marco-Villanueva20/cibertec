package arreglo;

import clase.Alumno;

import java.io.*;
import java.util.ArrayList;

public class ArregloAlumnos {
	
	//  Atributo privado
	private ArrayList <Alumno> alu;
	//  Constructor
    public ArregloAlumnos() {
    	alu = new ArrayList <Alumno> ();
		cargarAlumnos();
    }
	//  Operaciones públicas básicas
	public void adicionar(Alumno x) {
		alu.add(x);
		grabarAlumnos();
	}
    public int tamaño() {
		return alu.size();
	}
	public Alumno obtener(int i) {
		return alu.get(i);
	}
	public Alumno buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
	}
	public void eliminar(Alumno x) {
		alu.remove(x);
		grabarAlumnos();
	}
	public void actualizarArchivo() {
		grabarAlumnos();
	}
	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
					    x.getNombre() + ";" +
						x.getNota1() + ";" +
						x.getNota2();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarAlumnos() {
		try {
			BufferedReader br;
			String linea, nombre;
			String[] s;
			int codigo, nota1, nota2;
			br = new BufferedReader(new FileReader("alumnos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				nota1 = Integer.parseInt(s[2].trim());
				nota2 = Integer.parseInt(s[3].trim());
				adicionar(new Alumno(codigo, nombre, nota1, nota2));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
}