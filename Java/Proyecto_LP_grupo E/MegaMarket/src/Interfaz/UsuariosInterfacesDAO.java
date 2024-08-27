package Interfaz;

import java.util.ArrayList;

import Entidad.Usuarios;


public interface UsuariosInterfacesDAO {
	
	public int registrar(Usuarios u);
	public int ActualizarUsuario(Usuarios u);
	public int EliminarUsuario(int codigo);
	public ArrayList<Usuarios> buscar(String busqueda);
	public Usuarios obtener(int codigo);
	public ArrayList<Usuarios> listarUsuario();
	public Usuarios validarAcceso(String user,String pass);

}
