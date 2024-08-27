package entidad;

public class Estado {
	
	private int codigo;
	private String descEstado;
	
	//Constructor Vacio
	public Estado() {
	}
	//Constructor con parametros
	public Estado(int codigo, String descEstado) {
		super();
		this.codigo = codigo;
		this.descEstado = descEstado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescEstado() {
		return descEstado;
	}
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
}
