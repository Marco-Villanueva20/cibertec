package Interfaz;

import java.util.ArrayList;

import Entidad.Proveedor;

public interface ProveedorInterfacesDAO {
	
	public int registrarProveedor(Proveedor p);
	public int ActualizarProveedor(Proveedor p);
	public int EliminarProveedor(int codigo);
	public ArrayList<Proveedor> buscar(String busqueda);
	public Proveedor obtener(int codigo);
	public ArrayList<Proveedor> ListarProveedor();

}
