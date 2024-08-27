package entidad;

public class ReporteTipoUsuario {
	private int codigo;
	private String nomCompleto;
	private String descripTipoUsuario;
	
	public ReporteTipoUsuario() {};
	public ReporteTipoUsuario(int codigo, String nomCompleto, String descripTipoUsuario) {
		super();
		this.codigo = codigo;
		this.nomCompleto = nomCompleto;
		this.descripTipoUsuario = descripTipoUsuario;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomCompleto() {
		return nomCompleto;
	}
	public void setNomCompleto(String nomCompleto) {
		this.nomCompleto = nomCompleto;
	}
	public String getDescripTipoUsuario() {
		return descripTipoUsuario;
	}
	public void setDescripTipoUsuario(String descripTipoUsuario) {
		this.descripTipoUsuario = descripTipoUsuario;
	}
}
