package entidad;

public class CabeceraBoleta {
	private String numBoleta;
	private String fechaBol;
	private int codCliente;
	private int codVendedor;
	private double impTotalBoleta;
	
	
	public CabeceraBoleta() {}

	public CabeceraBoleta(String numBoleta, String fechaBol, int codCliente, int codVendedor, double impTotalBoleta) {
		this.numBoleta = numBoleta;
		this.fechaBol = fechaBol;
		this.codCliente = codCliente;
		this.codVendedor = codVendedor;
		this.impTotalBoleta = impTotalBoleta;
	}

	public String getNumBoleta() {
		return numBoleta;
	}

	public void setNumBoleta(String numBoleta) {
		this.numBoleta = numBoleta;
	}

	public String getFechaBol() {
		return fechaBol;
	}

	public void setFechaBol(String fechaBol) {
		this.fechaBol = fechaBol;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public int getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(int codVendedor) {
		this.codVendedor = codVendedor;
	}

	public double getImpTotalBoleta() {
		return impTotalBoleta;
	}

	public void setImpTotalBoleta(double impTotalBoleta) {
		this.impTotalBoleta = impTotalBoleta;
	}

	
	
}
