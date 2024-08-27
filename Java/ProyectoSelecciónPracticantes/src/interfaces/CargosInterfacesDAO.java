package interfaces;

import java.util.ArrayList;

import entidad.Cargos;

public interface CargosInterfacesDAO {
	public int numIdCargo();
	public int registro(Cargos car);
	public int actualizar(Cargos car);
	public int eliminar(int cod);

	public ArrayList<Cargos> listarCargo();
	public int obtIdCargo(String cargo);
	public ArrayList<Cargos> listarCargo(String nombre);
	
	
}
