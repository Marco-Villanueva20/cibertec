package interfaces;

import java.util.ArrayList;

import entidad.Areas;

public interface AreasInterfacesDAO {
	public int numIdArea();
	public int registro(Areas area);
	public int actualizar(Areas area);
	public int eliminar(int cod);
	
	public ArrayList<Areas> listarAreas();
	public int obtIdArea(String nomArea);
	
	public ArrayList<Areas> listarArea(String nombre);
}
