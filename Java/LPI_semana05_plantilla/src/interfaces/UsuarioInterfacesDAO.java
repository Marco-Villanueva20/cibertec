package interfaces;

import java.util.ArrayList;

import entidad.ReporteTipoUsuario;
import entidad.Usuario;

public interface UsuarioInterfacesDAO {
	//Se define los procesos  ---> métodos --> compromiso para el programador
	
	//Registrar Usuario
	public int registrar(Usuario u);
	//eliminar usuario
	public int eliminar(int codigo);
	//actualizar usuario
	public int actualizar(Usuario u);
	//buscar Usuario por codigo
	public Usuario buscarUsuario(int codigo);
	//listar usuario
	public ArrayList<Usuario> listarUsuario();
	public ArrayList<Usuario> listarUsuarioxTipo(int tipo);
	public ArrayList<ReporteTipoUsuario> listarReporteUsuario(int tipoUser);
	//validar el acceso al sistema
	public Usuario validarAcceso(String usr,String clave);
	
	
	public ArrayList<Usuario> listarUsuarioxFecha(String fnacim);
}
