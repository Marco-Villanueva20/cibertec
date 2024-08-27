package entidad;

public class ReporteMemorandum {
	private int codigo;
	private String emisor;
	private String emiCarArea;
	private String receptor;
	private String recCarArea;
	private String fecha;
	private String asunto;
	private String descripcion;

	
	
	public ReporteMemorandum() {
	}
	public ReporteMemorandum(int codigo, String emisor, String receptor, String fecha, String asunto) {
		this.codigo = codigo;
		this.emisor = emisor;
		this.receptor = receptor;
		this.fecha = fecha;
		this.asunto = asunto;
	}

	public ReporteMemorandum(int codigo, String emisor, String emiCarArea, String receptor, String recCarArea,
			String fecha, String asunto, String descripcion) {
		this.codigo = codigo;
		this.emisor = emisor;
		this.emiCarArea = emiCarArea;
		this.receptor = receptor;
		this.recCarArea = recCarArea;
		this.fecha = fecha;
		this.asunto = asunto;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getEmiCarArea() {
		return emiCarArea;
	}

	public void setEmiCarArea(String emiCarArea) {
		this.emiCarArea = emiCarArea;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getRecCarArea() {
		return recCarArea;
	}

	public void setRecCarArea(String recCarArea) {
		this.recCarArea = recCarArea;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

	
	
}
