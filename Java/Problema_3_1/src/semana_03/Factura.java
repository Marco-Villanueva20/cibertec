package semana_03;

public class Factura {
 //ATRIBUTOS PRIVADOS
	private String ruc;
	private String empresa;
	private int unidades;
	private double precio;
	//METODOS
	//VARIABLE PRIVADA DE CLASE CUENTA LA CANTIDAD DE OBJETOS
	private static int cantidad;
	//VARIABLE PRIVADA DE CLASE ACUMULE LOS IMPORTES FACTURADOS
	private static double total;
	//UNA CONSTANTE PUBLICA DE CLASE (String)
	public final String ENTIDAD;
	
	static {
		ENTIDAD = "Sunat";
	}
}
