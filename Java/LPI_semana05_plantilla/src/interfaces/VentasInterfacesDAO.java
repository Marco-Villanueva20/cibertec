package interfaces;

import java.util.ArrayList;

import entidad.CabeceraBoleta;
import entidad.DetalleBoleta;

public interface VentasInterfacesDAO {
	//metodos para generar el numero de boleta
	public String numBoleta();
	
	public int realizarVenta(CabeceraBoleta cBol,ArrayList<DetalleBoleta> dBol);
}
