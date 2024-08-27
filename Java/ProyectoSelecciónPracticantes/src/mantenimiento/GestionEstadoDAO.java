package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Estado;
import interfaces.EstadoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionEstadoDAO implements EstadoInterfacesDAO{

	@Override
	public ArrayList<Estado> listarEstado() {
		ArrayList<Estado> lista =new ArrayList<Estado>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Estado estado = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_estado order by id_estado asc;";
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			while(res.next()) {
				estado = new Estado();
				estado.setCodigo(res.getInt(1));
				estado.setDescEstado(res.getString(2));
			
			lista.add(estado);
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
	public int registro(Estado es) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "insert into tb_estado values (?,?);";

			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, es.getCodigo());
			pstm.setString(2, es.getDescEstado());
			

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
	public int actualizar(Estado es) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_estado set desc_estado = ? where id_estado = ?";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, es.getDescEstado());
			pstm.setInt(2, es.getCodigo());
			

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
	public int eliminar(int cod) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "delete from tb_estado where id_estado = ?;";
			pstm = con.prepareStatement(sql);

			pstm.setInt(1, cod);

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
	public int obtIdEstado(String estado) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			
			con = MySQLConexion8.getConexion();
		
			String sql = "select id_estado from tb_estado where desc_estado=?";
		
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, estado);
		
			rs = pstm.executeQuery();
			
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
	
	public ArrayList<Estado> listarEstado(String nombre) {
		ArrayList<Estado> lista =new ArrayList<Estado>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Estado estado = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_buscarEstadoxNombre(?)};";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			res = pstm.executeQuery();
			while(res.next()) {
				estado = new Estado();
				estado.setCodigo(res.getInt(1));
				estado.setDescEstado(res.getString(2));
			
			lista.add(estado);
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
	
	public int numIdEstado() {
		int codigo =0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet respuesta = null;
		
		try {
			String sql = "select max(id_estado)from tb_estado";
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
}
