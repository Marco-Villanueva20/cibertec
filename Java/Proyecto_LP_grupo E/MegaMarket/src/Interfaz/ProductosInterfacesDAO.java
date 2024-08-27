package Interfaz;

import java.util.ArrayList;

import Entidad.CategoriaProducto;
import Entidad.Productos;


public interface ProductosInterfacesDAO {
	
	public int registrarProducto(Productos p);
	public int ActualizarProducto(Productos p);
	public int EliminarProducto(int codigo);
	public ArrayList<Productos> buscar(String descripcion, CategoriaProducto categoria);
	public Productos obtener(int codigo);
	public ArrayList<Productos> listarProductos();

}
