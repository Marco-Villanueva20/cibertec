package entidad;

public class Memorandum {
	private int codigo;
	private int usuarioEmisor;
	private int usuarioReceptor;
	private String fecha;
	private String descripcion;
	private String asunto;
	
	public Memorandum() {
	}
	public Memorandum(int codigo, int usuarioEmisor, int usuarioReceptor, String fecha, String descripcion,
			String asunto) {
		this.codigo = codigo;
		this.usuarioEmisor = usuarioEmisor;
		this.usuarioReceptor = usuarioReceptor;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.asunto = asunto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getUsuarioEmisor() {
		return usuarioEmisor;
	}
	public void setUsuarioEmisor(int usuarioEmisor) {
		this.usuarioEmisor = usuarioEmisor;
	}
	public int getUsuarioReceptor() {
		return usuarioReceptor;
	}
	public void setUsuarioReceptor(int usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
	
}
