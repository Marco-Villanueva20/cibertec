package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Cargos;
import interfaces.CargosInterfacesDAO;
import utils.MySQLConexion8;

public class GestionCargosDAO implements CargosInterfacesDAO{
	
	@Override
	public int registro(Cargos car) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "insert into tb_cargos values (?,?);";

			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, car.getCodigo());
			pstm.setString(2, car.getDesCargo());
			

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
	public int actualizar(Cargos car) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_cargos set desc_cargo = ? where id_cargo = ?";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, car.getDesCargo());
			pstm.setInt(2, car.getCodigo());
			

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
			String sql = "delete from tb_cargos where id_cargo = ?;";
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
	public ArrayList<Cargos> listarCargo() {
		ArrayList<Cargos> lista =new ArrayList<Cargos>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Cargos cargos = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_cargos order by id_cargo asc";
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			while(res.next()) {
				cargos = new Cargos();
				cargos.setCodigo(res.getInt(1));
				cargos.setDesCargo(res.getString(2));
				
			lista.add(cargos);
			}
			
		} catch (Exception e) {
			System.out.println(">> Error en la instruccion SQL - Listar tabla Cargos "+e.getMessage());
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
	
	public int obtIdCargo(String cargo) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			
			con = MySQLConexion8.getConexion();
		
			String sql = "select id_cargo from tb_cargos where desc_cargo=?";
		
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, cargo);
		
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
	public ArrayList<Cargos> listarCargo(String nombre) {
		ArrayList<Cargos> lista =new ArrayList<Cargos>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Cargos cargo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_cargos where desc_cargo LIKE concat('%', ?,'%') order by id_cargo ASC;";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, nombre);
			res = pstm.executeQuery();
			while(res.next()) {
				cargo = new Cargos();
				cargo.setCodigo(res.getInt(1));
				cargo.setDesCargo(res.getString(2));
			
			lista.add(cargo);
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

	public int numIdCargo() {
		int codigo =0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet respuesta = null;
		
		try {
			String sql = "select max(id_cargo)from tb_cargos;";
			conn = MySQLConexion8.getConexion();
			pstm = conn.prepareStatement(sql);
			respuesta = pstm.executeQuery();
			if(respuesta.next()) {
				codigo = respuesta.getInt(1)+1;
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - obtener el numero de ID Cargo "+e.getMessage());
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
