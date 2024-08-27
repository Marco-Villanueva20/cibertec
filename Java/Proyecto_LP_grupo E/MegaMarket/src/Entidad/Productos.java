package Entidad;

public class Productos {
	
	private int codigo;
	private String descripcion;
	private int stock;
	private double precio;
	private CategoriaProducto categoriaProducto;
	private Proveedor proveedor;
	
	
	public Productos() {

	}


	public Productos(int codigo, String descripcion, int stock, double precio, CategoriaProducto categoriaProducto,
			Proveedor proveedor) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.categoriaProducto = categoriaProducto;
		this.proveedor = proveedor;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}


	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	

}
