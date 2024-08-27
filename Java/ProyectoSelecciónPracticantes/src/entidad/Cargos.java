package entidad;

public class Cargos {
	private int codigo;
	private String desCargo;
	
	//Constructor Vacio
	public Cargos() {}
	
	//Constructor con Parametros
	public Cargos(int codigo, String desCargo) {
		this.codigo = codigo;
		this.desCargo = desCargo;
	}
	
	//GET Y SET
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDesCargo() {
		return desCargo;
	}
	public void setDesCargo(String desCargo) {
		this.desCargo = desCargo;
	}
	
}
