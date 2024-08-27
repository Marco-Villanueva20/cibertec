package entidad;

public class TipoProducto {
	int codigo;
	String decripcion;
	public TipoProducto() {}
	public TipoProducto(int codigo, String decripcion) {
		super();
		this.codigo = codigo;
		this.decripcion = decripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDecripcion() {
		return decripcion;
	}
	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}
	
	
}
