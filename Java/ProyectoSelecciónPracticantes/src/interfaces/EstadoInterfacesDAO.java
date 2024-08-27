package interfaces;

import java.util.ArrayList;

import entidad.Estado;

public interface EstadoInterfacesDAO {
	public int numIdEstado();
	public ArrayList<Estado> listarEstado();
	public ArrayList<Estado> listarEstado(String nombre);
	
	
	public int registro(Estado e);
	public int actualizar(Estado e);
	public int eliminar(int cod);
	
	public int obtIdEstado(String estado);
}
