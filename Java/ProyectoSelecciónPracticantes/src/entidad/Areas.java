package entidad;

public class Areas {
	private int codigo;
	private String descArea;
	
	//Constructor Vacio
	public Areas() {}
	
	//Constructor Con Parametros
	public Areas(int codigo, String descArea) {
		this.codigo = codigo;
		this.descArea = descArea;
	}
	
	//GET Y SET
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescArea() {
		return descArea;
	}
	public void setDescArea(String descArea) {
		this.descArea = descArea;
	}
}
