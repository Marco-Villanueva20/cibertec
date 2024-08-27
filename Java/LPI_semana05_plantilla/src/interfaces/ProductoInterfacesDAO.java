package interfaces;

import java.util.ArrayList;

import entidad.Producto;
import entidad.ReporteIdProducto;

public interface ProductoInterfacesDAO {
	//registrar productos
	public int registrar(Producto prod);
	public int actualizar(Producto prod);
	public ArrayList<Producto> listarProductos();
	//tarea buscar y eliminar
	public int eliminiar(String codigo);
	public Producto buscar(String buscarProd);
	
	public ArrayList<ReporteIdProducto> bucarProducto(String codigo);
	
	public ArrayList<Producto> listar(String nomProd);
}
