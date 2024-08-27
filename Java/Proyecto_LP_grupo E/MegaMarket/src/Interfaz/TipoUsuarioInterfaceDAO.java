package Interfaz;

import java.util.ArrayList;

import Entidad.TipoUsuario;

public interface TipoUsuarioInterfaceDAO {
	
	public ArrayList<TipoUsuario> listar();
	public TipoUsuario obtener(int codigo);

}
