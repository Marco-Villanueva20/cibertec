package entidad;

public class TipoUsuario {
	//
	private int idTipo;
	private String descripTipo;
	
	//constructores
	public TipoUsuario() {}
	public TipoUsuario(int idTipo,String descripTipo) {
		this.idTipo=idTipo;
		this.descripTipo=descripTipo;
	}
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getDescripTipo() {
		return descripTipo;
	}
	public void setDescripTipo(String descripTipo) {
		this.descripTipo = descripTipo;
	}

}
