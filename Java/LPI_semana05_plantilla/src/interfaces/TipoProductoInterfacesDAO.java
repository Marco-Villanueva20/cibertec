package interfaces;

import entidad.ReporteIdUsuario;
import java.util.ArrayList;

import entidad.TipoProducto;


public interface TipoProductoInterfacesDAO {
	public ArrayList<TipoProducto>listarTipoProducto();
	public ReporteIdUsuario reportexId(String codigo);
}
