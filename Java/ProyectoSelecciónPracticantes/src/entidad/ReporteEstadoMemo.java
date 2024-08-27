package entidad;

public class ReporteEstadoMemo {
	private int codMemo;
	private String descEstado;
	private String nomUsuarioRev;
	private String fechaRegistrada;
	private String hora;
	private String observacion;
	public ReporteEstadoMemo(int codMemo, String descEstado, String nomUsuarioRev, String fechaRegistrada, String hora,
			String observacion) {
		this.codMemo = codMemo;
		this.descEstado = descEstado;
		this.nomUsuarioRev = nomUsuarioRev;
		this.fechaRegistrada = fechaRegistrada;
		this.hora = hora;
		this.observacion = observacion;
	}
	public ReporteEstadoMemo() {
	}
	public int getCodMemo() {
		return codMemo;
	}
	public void setCodMemo(int codMemo) {
		this.codMemo = codMemo;
	}
	public String getDescEstado() {
		return descEstado;
	}
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
	public String getNomUsuarioRev() {
		return nomUsuarioRev;
	}
	public void setNomUsuarioRev(String nomUsuarioRev) {
		this.nomUsuarioRev = nomUsuarioRev;
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
	
	
	
}
