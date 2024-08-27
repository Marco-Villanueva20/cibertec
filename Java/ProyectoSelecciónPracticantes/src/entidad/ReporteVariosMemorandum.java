package entidad;

public class ReporteVariosMemorandum {
	private int codigo;
	private String remitente;
	private String destinatario;
	private String fecha;
	private String asunto;
	
	
	public ReporteVariosMemorandum() {
	}
	public ReporteVariosMemorandum(int codigo, String remitente, String destinatario, String fecha, String asunto) {
		this.codigo = codigo;
		this.remitente = remitente;
		this.destinatario = destinatario;
		this.fecha = fecha;
		this.asunto = asunto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
}
