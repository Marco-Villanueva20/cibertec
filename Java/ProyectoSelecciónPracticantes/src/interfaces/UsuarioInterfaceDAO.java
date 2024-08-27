package interfaces;

import java.util.ArrayList;

import entidad.ListaUsuarios;
import entidad.Usuario;

public interface UsuarioInterfaceDAO {
	
	
	public int numIdUsuario();
	
	public int registrar(Usuario u);
	public int actualizar(Usuario u);
	public int eliminar(int id_usuario);
	
	public ArrayList<ListaUsuarios> buscarUsuarioxNomxApexArea(String nombre,String apellido, String area);
	public ArrayList<ListaUsuarios> listarUsuarios();
	public Usuario validarAcceso(String usuario, String clave);
	public ListaUsuarios userEspecifico(int cod);
	
	public int obtIdUsuario(String nombre, String apellido); 
	
	
	
}
