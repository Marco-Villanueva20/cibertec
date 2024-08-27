package entidad;

public class Usuario {
	//atributos privados 
	
		private int id;
		private String nombre;
		private String apellidos;
		private String fechaNacimiento;
		private int cargo;
		private int area;
		private String usuario;
		private String clave;


	//constructores -->2
	
		public Usuario() {
		}


	public Usuario(int id, String nombre, String apellidos, String fechaNacimiento, int cargo, int area, String usuario,
			String clave) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.cargo = cargo;
		this.area = area;
		this.usuario = usuario;
		this.clave = clave;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getCargo() {
		return cargo;
	}


	public void setCargo(int cargo) {
		this.cargo = cargo;
	}


	public int getArea() {
		return area;
	}


	public void setArea(int area) {
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
