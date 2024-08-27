package semana_01;

public class Filmacion {
	//ATRIBUTOS
	public int codigo;
	public String titulo;
	public int durMinutos;
	public double precSoles;
	//METODOS
	public double precio() {
		return precSoles / 3.59;
	}
}
