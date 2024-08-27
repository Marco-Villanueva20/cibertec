package entidad;

public class ListaUsuarios {
	private int codigo;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String cargo;
	private String area;
	private String usuario;
	private String clave;

	public ListaUsuarios() {
	}

	public ListaUsuarios(int codigo, String nombre, String apellido, String fechaNacimiento, String cargo, String area,
			String usuario, String clave) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.cargo = cargo;
		this.area = area;
		this.usuario = usuario;
		this.clave = clave;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
