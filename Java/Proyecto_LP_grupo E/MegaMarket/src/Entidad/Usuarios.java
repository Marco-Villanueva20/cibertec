package Entidad;

public class Usuarios {
	
	private int codigo;
	private String nombre;
	private String pass;
	private TipoUsuario tipousuario;
	private Estados estado; 
	
	public Usuarios() {

	}

	public Usuarios(int codigo, String nombre, String pass, TipoUsuario tipousuario, Estados estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.pass = pass;
		this.tipousuario = tipousuario;
		this.estado = estado;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public TipoUsuario getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(TipoUsuario tipousuario) {
		this.tipousuario = tipousuario;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	

}
