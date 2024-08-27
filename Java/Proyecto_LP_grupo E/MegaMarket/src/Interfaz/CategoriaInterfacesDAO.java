package Interfaz;

import java.util.ArrayList;

import Entidad.CategoriaProducto;

public interface CategoriaInterfacesDAO {
	
	public ArrayList<CategoriaProducto> listar();
	public CategoriaProducto obtener(int codigo);
	

}
