package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.ListaUsuarios;
import entidad.Usuario;
import interfaces.UsuarioInterfaceDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfaceDAO {

	@Override
	public int registrar(Usuario u) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "insert into tb_usuarios values (?,?,?,?,?,?,?,?);";

			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, u.getId());
			pstm.setString(2, u.getNombre());
			pstm.setString(3, u.getApellidos());
			pstm.setString(4, u.getFechaNacimiento());
			pstm.setInt(5, u.getCargo());
			pstm.setInt(6, u.getArea());
			pstm.setString(7, u.getUsuario());
			pstm.setString(8, u.getClave());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>>> Error en la instruccion SQL - registrar " + e.getMessage());
		} finally {
			try {

				if (pstm != null)	pstm.close();
				if (con != null)	con.close();

			} catch (SQLException e2) {
				System.out.println(">>>>>>>>>>>>>>>>>> Error al cerrar la base de Datos " + e2.getMessage());

			}
		}

		return res;
	}

	@Override
	public int eliminar(int id_usuario) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "delete from tb_usuarios where id_usuario = ?;";
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, id_usuario);

			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Eliminar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base datos" + e2.getMessage());

			}
		}

		return res;
	}

	@Override
	public int actualizar(Usuario u) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_usuarios set nombre = ?,apellidos = ?, fech_nac = ? ,cargo =?,area=?, usuario = ? , clave = ? where id_usuario = ?";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellidos());
			pstm.setString(3, u.getFechaNacimiento());
			pstm.setInt(4, u.getCargo());
			pstm.setInt(5, u.getArea());
			pstm.setString(6, u.getUsuario());
			pstm.setString(7, u.getClave());
			pstm.setInt(8, u.getId());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Actualizar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public ArrayList<ListaUsuarios> buscarUsuarioxNomxApexArea(String nombre,String apellido, String area) {
		ArrayList<ListaUsuarios> lista = new ArrayList<ListaUsuarios>();
		ListaUsuarios listaUsuario = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();

			String sql = "{call usp_buscarUsuarioxNomxApexArea(?,?,?)}";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, nombre);
			pstm.setString(2, apellido);
			pstm.setString(3, area);

			res = pstm.executeQuery();
			while (res.next()) {
				
				listaUsuario = new ListaUsuarios();
				// setear(asignar los valores a los atributos privados
				listaUsuario.setCodigo(res.getInt(1));
				listaUsuario.setNombre(res.getString(2));
				listaUsuario.setApellido(res.getString(3));
				listaUsuario.setFechaNacimiento(res.getString(4));
				listaUsuario.setCargo(res.getString(5));
				listaUsuario.setArea(res.getString(6));
				listaUsuario.setUsuario(res.getString(7));
				listaUsuario.setClave(res.getString(8));

				// paso7 --> añadir el usuario a la lista
				lista.add(listaUsuario);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta de busqueda" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<ListaUsuarios> listarUsuarios() {
		ArrayList<ListaUsuarios> lista = new ArrayList<ListaUsuarios>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ListaUsuarios listaUsuarios = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "{call usp_listarUsuario()}";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();
			// paso6 --> bluce para realizar el recorrido al opbjeto "res"
			while (res.next()) {
				
				listaUsuarios = new ListaUsuarios();
				// setear(asignar los valores a los atributos privados
				listaUsuarios.setCodigo(res.getInt(1));
				listaUsuarios.setNombre(res.getString(2));
				listaUsuarios.setApellido(res.getString(3));
				listaUsuarios.setFechaNacimiento(res.getString(4));
				listaUsuarios.setCargo(res.getString(5));
				listaUsuarios.setArea(res.getString(6));
				listaUsuarios.setUsuario(res.getString(7));
				listaUsuarios.setClave(res.getString(8));

				// paso7 --> añadir el usuario a la lista
				lista.add(listaUsuarios);
			}

		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - LISTA DE USUARIOS" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());

			}
		}

		return lista;

	}

	public Usuario validarAcceso(String usuario, String clave) {
		Usuario user = new Usuario();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			String sql = "select * from tb_usuarios where usuario =? and clave=?;";

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, usuario);
			pstm.setString(2, clave);

			res = pstm.executeQuery();

			if (res.next()) {
				user = new Usuario(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5),
						res.getInt(6), res.getString(7), res.getString(8));
			}

		} catch (Exception e) {
			System.out.println("Error en la consulta de búsqueda " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return user;

	}
	@Override
	public int obtIdUsuario(String nombre, String apellido) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select id_usuario from tb_usuarios where nombre=? AND apellidos=?";
		
			pstm = con.prepareStatement(sql);// obtener comandos sql
			
			pstm.setString(1, nombre);
			pstm.setString(2, apellido);
			
			rs = pstm.executeQuery();
		
			if (rs.next()) {
				res = rs.getInt(1);
			}else {
			    res = -1; // si no se encontró un resultado, devolver -1
			}

		} catch (Exception e) {
			System.out.println(" >>>> Error en la instrucción SQL - Obtener ID Usuario " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("<< Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return res;
		}

	
		public int numIdUsuario() {
			int codigo =0;
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet respuesta = null;
			
			try {
				String sql = "select max(id_usuario)from tb_usuarios;";
				conn = MySQLConexion8.getConexion();
				pstm = conn.prepareStatement(sql);
				respuesta = pstm.executeQuery();
				if(respuesta.next()) {
					codigo = respuesta.getInt(1)+1;
				}
			} catch (Exception e) {
				System.out.println("Error en la instrucción SQL - obtener el numero de ID Estado "+e.getMessage());
			}finally {
				try {
					if(conn!=null)conn.close();
					if(pstm!=null)pstm.close();
					if(respuesta!=null)respuesta.close();
				} catch (SQLException e2) {
					System.out.println("Error al cerrar la BD "+e2.getMessage());
				}
			}
			return codigo;
		}

		@Override
		public ListaUsuarios userEspecifico(int cod) {
			ListaUsuarios user = new ListaUsuarios();
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			try {
				conn = MySQLConexion8.getConexion();
				String sql = "{call bd_memoradum.usuarioXid(?)} ";

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, cod);
				
				res = pstm.executeQuery();

				if (res.next()) {
					user = new ListaUsuarios(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),
							res.getString(6), res.getString(7), res.getString(8));
				}

			} catch (Exception e) {
				System.out.println("Error en la consulta de búsqueda " + e.getMessage());
			} finally {
				try {
					if (pstm != null)
						pstm.close();
					if (res != null)
						res.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e2) {
					System.out.println("Error al cerrar la base de datos " + e2.getMessage());
				}
			}
			return user;
		}
}
	

