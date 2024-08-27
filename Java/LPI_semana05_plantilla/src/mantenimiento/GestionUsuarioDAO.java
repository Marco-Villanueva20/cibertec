package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.ReporteTipoUsuario;
import entidad.Usuario;
import interfaces.UsuarioInterfacesDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfacesDAO {

	@Override
	public int registrar(Usuario u) {
		// Declaración de Variable
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// Paso 1 :Establecer la conexion de la base de datos
			con = MySQLConexion8.getConexion();
			// Paso 2: Establecer la instruccion SQL -- Registrar
			String sql = "insert into tb_usuarios values(null,?,?,?,?,?,?,default)";
			// Paso 3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);// obtener comandos sql
			// Paso 4 : Obtener los parametros de ingreso
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setString(5, u.getFechNacimiento());
			pstm.setInt(6, u.getTipo());
			// Pao 5: ejecutar la instruccion
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(" >>>> Error en la instrucción SQL - Registrar " + e.getMessage());
		} finally {
			try {
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

	@Override
	public int eliminar(int codigo) {

		int res = 0;

		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// paso 1: establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2: establecer la instruccion SQL -- para eliminar
			String sql = "delete from tb_usuarios where codigo = ?";
			// paso 3 --> enviar la instrucción al objeto pstm -- para obtener los comandos
			// sql
			pstm = con.prepareStatement(sql);
			// paso 4 -- obtener el parametro = ?;
			pstm.setInt(1, codigo);

			// paso 5 -- ejecutar la instruccion sql
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Eliminar: " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
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
			// paso 1: establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2: establecer la instruccion SQL -- para eliminar
			String sql = "update  tb_usuarios set nombre= ?, apellido= ?, usuario= ?,clave= ?,fnacim= ?,tipo=? where codigo = ?";
			// paso 3 --> enviar la instrucción al objeto pstm -- para obtener los comandos
			// sql
			pstm = con.prepareStatement(sql);
			// paso 4 -- obtener el parametro = ?;
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setString(5, u.getFechNacimiento());
			pstm.setInt(6, u.getTipo());
			pstm.setInt(7, u.getCodigo());

			// paso 5 -- ejecutar la instruccion sql
			res = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Actualizar: " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}

		}
		return res;
	}

	@Override
	public Usuario buscarUsuario(int codigo) {
		Usuario user = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// paso 1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// paso 2 --> Establecer la instruccion SQL - Consulta de usurio po codigo
			String sql = "select * from tb_usuarios where codigo = ?;";
			// paso 3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// paso 4 --> parametros
			pstm.setInt(1, codigo);
			// paso 5 --> ejecutar la consulta
			res = pstm.executeQuery();
			// paso 6 --> Setear los valores
			if (res.next()) {
				user = new Usuario(
						res.getInt(1), 
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getInt(7),
						res.getInt(8));
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta de búsqueda " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return user;
	}

	@Override
	public ArrayList<Usuario> listarUsuario() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Usuario user = null;

		try {
			// paso 1 conectar a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2 establecer la instruccion sql
			String sql = "SELECT * FROM ciberfarma.tb_usuarios;";
			// paso 3
			pstm = con.prepareStatement(sql);
			// paso 4 --> no se necesita

			// paso 5 ejecutar la instruccion sql
			res = pstm.executeQuery();
			// paso 6 bucle para realizar el recorrido al objeto res
			while (res.next()) {
				// Crear objeto de tipo Usuario
				user = new Usuario();
				// setear(asignar los valores a los atributos privados
				user.setCodigo(res.getInt(1));
				user.setNombre(res.getString(2));
				user.setApellido(res.getString(3));
				user.setUsuario(res.getString(4));
				user.setClave(res.getString(5));
				user.setFechNacimiento(res.getString(6));
				user.setTipo(res.getInt(7));
				user.setEstado(res.getInt(8));

				// 7 añadir el usuario a la lista
				lista.add(user);
			}

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL");
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<Usuario> listarUsuarioxTipo(int tipo) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		Usuario user = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// paso 1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// paso 2 --> Establecer la instruccion SQL - Consulta de usurio po codigo
			String sql = "select * from tb_usuarios where tipo = ?;";
			// paso 3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// paso 4 --> parametros
			pstm.setInt(1, tipo);
			// paso 5 --> ejecutar la consulta
			res = pstm.executeQuery();
			// paso 6 bucle para realizar el recorrido al objeto res
			while (res.next()) {
				// Crear objeto de tipo Usuario
				user = new Usuario();
				// setear(asignar los valores a los atributos privados
				user.setCodigo(res.getInt(1));
				user.setNombre(res.getString(2));
				user.setApellido(res.getString(3));
				user.setUsuario(res.getString(4));
				user.setClave(res.getString(5));
				user.setFechNacimiento(res.getString(6));
				user.setTipo(res.getInt(7));
				user.setEstado(res.getInt(8));

				// 7 añadir el usuario a la lista
				lista.add(user);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta de búsqueda " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<ReporteTipoUsuario> listarReporteUsuario(int tipoUser) {
		ArrayList<ReporteTipoUsuario> lista = new ArrayList<ReporteTipoUsuario>();
		ReporteTipoUsuario tipUser = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// paso 1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// paso 2 --> Establecer la instruccion SQL - Consulta de usurio po codigo
			String sql = "{call usp_listarusuariotipo(?)}";
			// paso 3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// paso 4 --> parametros
			pstm.setInt(1, tipoUser);
			// paso 5 --> ejecutar la consulta
			res = pstm.executeQuery();
			// paso 6 bucle para realizar el recorrido al objeto res
			while (res.next()) {
				// Crear objeto de tipo Usuario
				tipUser = new ReporteTipoUsuario();
				// setear(asignar los valores a los atributos privados
				tipUser.setCodigo(res.getInt(1));
				tipUser.setNomCompleto(res.getString(2));
				tipUser.setDescripTipoUsuario(res.getString(3));
				

				// 7 añadir el usuario a la lista
				lista.add(tipUser);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta de búsqueda " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<Usuario> listarUsuarioxFecha(String fnacim) {

			ArrayList<Usuario> lista = new ArrayList<Usuario>();
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			Usuario user = null;

			try {
				// paso 1 conectar a la base de datos
				con = MySQLConexion8.getConexion();
				// paso 2 establecer la instruccion sql
				String sql = "select * from tb_usuarios where fnacim = ?;";
				// paso 3
				pstm = con.prepareStatement(sql);
				// paso 4 --> no se necesita
				pstm.setString(1, fnacim);
				// paso 5 ejecutar la instruccion sql
				res = pstm.executeQuery();
				// paso 6 bucle para realizar el recorrido al objeto res
				while (res.next()) {
					// Crear objeto de tipo Usuario
					user = new Usuario();
					// setear(asignar los valores a los atributos privados
					user.setCodigo(res.getInt(1));
					user.setNombre(res.getString(2));
					user.setApellido(res.getString(3));
					user.setUsuario(res.getString(4));
					user.setClave(res.getString(5));
					user.setFechNacimiento(res.getString(6));
					user.setTipo(res.getInt(7));
					user.setEstado(res.getInt(8));

					// 7 añadir el usuario a la lista
					lista.add(user);
				}

			} catch (Exception e) {
				System.out.println("Error en la instrucción SQL");
			} finally {
				try {
					if (pstm != null)
						pstm.close();
					if (res != null)
						res.close();
					if (con != null)
						con.close();
				} catch (SQLException e2) {
					System.out.println("Error al cerrar la base de datos " + e2.getMessage());
				}
			}

			return lista;
		}

	@Override
	public Usuario validarAcceso(String usr, String clave) {
		Usuario user = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_validarAcceso(?,?)};";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usr);
			pstm.setString(2, clave);
			res = pstm.executeQuery();
			if (res.next()) {
				user = new Usuario(
						res.getInt(1), 
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getInt(7),
						res.getInt(8));
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta de validación " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return user;
	}
}
