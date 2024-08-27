package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Areas;
import interfaces.AreasInterfacesDAO;
import utils.MySQLConexion8;

public class GestionAreasDAO implements AreasInterfacesDAO {
	
	@Override
	public int registro(Areas area) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "insert into tb_areas values (?,?);";

			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, area.getCodigo());
			pstm.setString(2, area.getDescArea());
			

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
	public int actualizar(Areas area) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_areas set desc_area = ? where id_area = ?";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, area.getDescArea());
			pstm.setInt(2, area.getCodigo());
			

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
			String sql = "delete from tb_areas where id_area = ?;";
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
	public ArrayList<Areas> listarAreas() {
		ArrayList<Areas> lista =new ArrayList<Areas>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Areas areas = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_areas order by id_area ASC;";
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			while(res.next()) {
				areas = new Areas();
				areas.setCodigo(res.getInt(1));
				areas.setDescArea(res.getString(2));
			
			lista.add(areas);
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
	public int obtIdArea(String nomArea) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "select id_area from tb_areas where desc_area=?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, nomArea);
		
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

	@Override
	public ArrayList<Areas> listarArea(String nombre) {
		ArrayList<Areas> lista =new ArrayList<Areas>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Areas area = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_areas where desc_area LIKE concat('%',?,'%') order by id_area ASC;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			res = pstm.executeQuery();
			while(res.next()) {
				area = new Areas();
				area.setCodigo(res.getInt(1));
				area.setDescArea(res.getString(2));
			
			lista.add(area);
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
	
	public int numIdArea() {
		int codigo =0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet respuesta = null;
		
		try {
			String sql = "select max(id_area)from tb_areas;";
			conn = MySQLConexion8.getConexion();
			pstm = conn.prepareStatement(sql);
			respuesta = pstm.executeQuery();
			if(respuesta.next()) {
				codigo = respuesta.getInt(1)+1;
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - obtener el numero de ID Area "+e.getMessage());
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
