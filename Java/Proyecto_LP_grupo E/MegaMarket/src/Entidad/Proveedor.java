package Entidad;

public class Proveedor {
	
	private int codigo;
	private String nombre;
	private String ruc;
	private String direccion;
	
	
	public Proveedor() {
	}
	
	public Proveedor(int codigo, String nombre, String ruc, String direccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ruc = ruc;
		this.direccion = direccion;
	}

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String toString(){
		return getNombre();
	}
	
}
