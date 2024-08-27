package entidad;

public class DetalleBoleta {
	private String numBoleta;
	private String idProd;
	private int cantidad;
	private double precioVenta;
	private double importe;
	
	public DetalleBoleta() {
	}

	public DetalleBoleta(String numBoleta, String idProd, int cantidad, double precioVenta, double importe) {
		this.numBoleta = numBoleta;
		this.idProd = idProd;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.importe = importe;
	}

	public String getNumBoleta() {
		return numBoleta;
	}

	public void setNumBoleta(String numBoleta) {
		this.numBoleta = numBoleta;
	}

	public String getIdProd() {
		return idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
	
}
