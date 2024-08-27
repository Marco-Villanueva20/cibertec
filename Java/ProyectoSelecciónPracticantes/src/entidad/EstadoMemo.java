package entidad;

public class EstadoMemo {
	private int codMemo;
	private int codEstado;
	private int codUsuarioRev;
	private String fechaRegistrada;
	private String hora;
	private String observacion;
	private int orden;
	
	public EstadoMemo() {
	}
	public EstadoMemo(int codMemo, int codEstado, int codUsuarioRev, String fechaRegistrada, String hora,
			String observacion, int orden) {
		this.codMemo = codMemo;
		this.codEstado = codEstado;
		this.codUsuarioRev = codUsuarioRev;
		this.fechaRegistrada = fechaRegistrada;
		this.hora = hora;
		this.observacion = observacion;
		this.orden = orden;
	}
	
	public int getCodMemo() {
		return codMemo;
	}
	public void setCodMemo(int codMemo) {
		this.codMemo = codMemo;
	}
	public int getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(int codEstado) {
		this.codEstado = codEstado;
	}
	public int getCodUsuarioRev() {
		return codUsuarioRev;
	}
	public void setCodUsuarioRev(int codUsuarioRev) {
		this.codUsuarioRev = codUsuarioRev;
	}
	public String getFechaRegistrada() {
		return fechaRegistrada;
	}
	public void setFechaRegistrada(String fechaRegistrada) {
		this.fechaRegistrada = fechaRegistrada;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	
	
}
