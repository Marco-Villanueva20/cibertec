package Interfaz;

import java.util.ArrayList;

import Entidad.Estados;

public interface EstadosInterfacesDAO {
	
	public ArrayList<Estados> listar();
	public Estados obtener (int codigo);

}
