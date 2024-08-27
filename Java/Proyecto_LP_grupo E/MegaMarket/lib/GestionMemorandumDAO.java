package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.ListaMemorandum;
import entidad.Memorandum;
import interfaces.MemorandumInterfacesDAO;
import utils.MySQLConexion8;

public class GestionMemorandumDAO implements MemorandumInterfacesDAO{

	@Override
	public int registrar(Memorandum m) {
			int res = 0;
			Connection con = null;
			PreparedStatement pstm = null;
			try {
				// Paso 1 :Establecer la conexion de la base de datos
				con = MySQLConexion8.getConexion();
				// Paso 2: Establecer la instruccion SQL -- Registrar
				String sql = "insert into tb_memo values(?,?,?,?,?,?);";
				// Paso 3: Crear el objeto pstm y enviar la variable sql
				pstm = con.prepareStatement(sql);// obtener comandos sql
				// Paso 4 : Obtener los parametros de ingreso
				pstm.setInt(1, m.getCodigo());
				pstm.setString(2,m.getFecha());
				pstm.setString(3, m.getTipo());
				pstm.setInt(4, m.getDestino());
				pstm.setInt(5, m.getEstado());
				pstm.setInt(6, m.getUsuario());
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
	public int obtIdArea(String nomArea) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Paso 1: Establecer la conexion de la base de datos
			con = MySQLConexion8.getConexion();
			// Paso 2: Establecer la instruccion SQL
			String sql = "select id_area from tb_areas where desc_area=?";
			// Paso 3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);// obtener comandos sql
			// Paso 4: Obtener los parametros de ingreso
			pstm.setString(1, nomArea);
			// Paso 5: Ejecutar la instruccion
			rs = pstm.executeQuery();
			// Paso 6: Obtener los resultados
			if (rs.next()) {
				res = rs.getInt(1);
			}else {
			    res = -1; // si no se encontró un resultado, devolver -1
			}

		} catch (Exception e) {
			System.out.println(" >>>> Error en la instrucción SQL - Registrar " + e.getMessage());
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



	@Override
	public int obtIdEstado(String estado) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Paso 1: Establecer la conexion de la base de datos
			con = MySQLConexion8.getConexion();
			// Paso 2: Establecer la instruccion SQL
			String sql = "select is_estado from tb_estado where desc_estado=?";
			// Paso 3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);// obtener comandos sql
			// Paso 4: Obtener los parametros de ingreso
			pstm.setString(1, estado);
			// Paso 5: Ejecutar la instruccion
			rs = pstm.executeQuery();
			// Paso 6: Obtener los resultados
			if (rs.next()) {
				res = rs.getInt(1);
			}else {
			    res = -1; // si no se encontró un resultado, devolver -1
			}

		} catch (Exception e) {
			System.out.println(" >>>> Error en la instrucción SQL - Registrar " + e.getMessage());
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



	@Override
	public int obtIdUsuario(String nombre, String apellido) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// Paso 1: Establecer la conexion de la base de datos
			con = MySQLConexion8.getConexion();
			// Paso 2: Establecer la instruccion SQL
			String sql = "select id_usuario from tb_usuarios where nombre=? AND apellidos=?";
			// Paso 3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);// obtener comandos sql
			// Paso 4: Obtener los parametros de ingreso
			pstm.setString(1, nombre);
			pstm.setString(2, apellido);
			// Paso 5: Ejecutar la instruccion
			rs = pstm.executeQuery();
			// Paso 6: Obtener los resultados
			if (rs.next()) {
				res = rs.getInt(1);
			}else {
			    res = -1; // si no se encontró un resultado, devolver -1
			}

		} catch (Exception e) {
			System.out.println(" >>>> Error en la instrucción SQL - Registrar " + e.getMessage());
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


	@Override
	public ArrayList<ListaMemorandum> listarMemo() {
		ArrayList<ListaMemorandum> lista =new ArrayList<ListaMemorandum>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ListaMemorandum listaMemo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "CALL usp_memorandum();";
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			while(res.next()) {
				listaMemo = new ListaMemorandum();
				listaMemo.setId_memo(res.getInt(1));
				listaMemo.setNombre(res.getString(2));
				listaMemo.setApellido(res.getString(3));
				listaMemo.setArea(res.getString(4));
				listaMemo.setFecha(res.getString(5));
				listaMemo.setTipo(res.getString(6));
				listaMemo.setEstado(res.getString(7));
			lista.add(listaMemo);
			}
			
		} catch (Exception e) {
			System.out.println(">> Error en la instruccion SQL "+e.getMessage());
		}finally {
			try {
				if(con!= null)con.close();
				if(pstm != null)pstm.close();
				if(res!=null)res.close();
			} catch (SQLException e2) {
				System.out.println("<<Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		
		return lista;
	}


	@Override
	public int actualizar(Memorandum m) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// Paso 1 :Establecer la conexion de la base de datos
			con = MySQLConexion8.getConexion();
			// Paso 2: Establecer la instruccion SQL -- Registrar
			String sql = "UPDATE tb_memo set fecha=?,tipo=?,destino=?,estado=?,usuario=? where cod_memo= ?;";
			// Paso 3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);// obtener comandos sql
			// Paso 4 : Obtener los parametros de ingreso
			pstm.setString(1,m.getFecha());
			pstm.setString(2, m.getTipo());
			pstm.setInt(3, m.getDestino());
			pstm.setInt(4, m.getEstado());
			pstm.setInt(5, m.getUsuario());
			pstm.setInt(6, m.getCodigo());
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
	public int eliminar(int cod) {
		int res = 0;

		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// paso 1: establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2: establecer la instruccion SQL -- para eliminar
			String sql = "Delete  from tb_memo where cod_memo =?;";
			// paso 3 --> enviar la instrucción al objeto pstm -- para obtener los comandos
			// sql
			pstm = con.prepareStatement(sql);
			// paso 4 -- obtener el parametro = ?;
			pstm.setInt(1, cod);

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
	public ArrayList<ListaMemorandum> buscarMemo(String codigo) {
		ArrayList<ListaMemorandum> lista =new ArrayList<ListaMemorandum>();
		ListaMemorandum mem = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// paso 1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// paso 2 --> Establecer la instruccion SQL - Consulta de usurio po codigo
			String sql = "Call usp_BuscarMemo(?);";
			// paso 3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// paso 4 --> parametros
			pstm.setString(1, codigo);
			// paso 5 --> ejecutar la consulta
			res = pstm.executeQuery();
			// paso 6 --> Setear los valores
			while(res.next()) {
				mem = new ListaMemorandum();
				mem.setId_memo(res.getInt(1));
				mem.setNombre(res.getString(2));
				mem.setApellido(res.getString(3));
				mem.setArea(res.getString(4));
				mem.setFecha(res.getString(5));
				mem.setTipo(res.getString(6));
				mem.setEstado(res.getString(7));
			lista.add(mem);
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

	
	}

