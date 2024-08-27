package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.EstadoMemo;
import entidad.ReporteEstadoMemo;
import interfaces.EstadoMemoInterfaceDAO;
import utils.MySQLConexion8;

public class GestionEstadoMemoDAO implements EstadoMemoInterfaceDAO {
	
	@Override
	public ArrayList<ReporteEstadoMemo> reporteEstMemo(int revision) {
		ArrayList<ReporteEstadoMemo> lista =new ArrayList<ReporteEstadoMemo>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReporteEstadoMemo repEstMemo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_estadoMemoxReceptor(?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, revision);
			res = pstm.executeQuery();
			while(res.next()) {
				repEstMemo = new ReporteEstadoMemo();
				repEstMemo.setCodMemo(res.getInt(1));
				repEstMemo.setDescEstado(res.getString(2));
				repEstMemo.setNomUsuarioRev(res.getString(3));
				repEstMemo.setFechaRegistrada(res.getString(4));
				repEstMemo.setHora(res.getString(5));
				repEstMemo.setObservacion(res.getString(6));
			
			lista.add(repEstMemo);
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
	public int finalizar(EstadoMemo estMemo) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {

			conn = MySQLConexion8.getConexion();

			String sql = "INSERT INTO tb_estado_memo VALUES(?,?,?,?,?,?,?);";

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, estMemo.getCodMemo());
			pstm.setInt(2, estMemo.getCodEstado());
			pstm.setInt(3, estMemo.getCodUsuarioRev());
			pstm.setString(4, estMemo.getFechaRegistrada());
			pstm.setString(5, estMemo.getHora());
			pstm.setString(6, estMemo.getObservacion());
			pstm.setInt(7, estMemo.getOrden());
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Finalizar estado Memo" + e.getMessage());
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int asignar(EstadoMemo estMemo1, EstadoMemo estMemo2) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		
		
		try {
			conn= MySQLConexion8.getConexion();
			conn.setAutoCommit(false);
			
			String sql1 = "INSERT INTO tb_estado_memo VALUES(?,?,?,?,?,?,?);";
			pstm1 = conn.prepareStatement(sql1);

			pstm1.setInt(1, estMemo1.getCodMemo());
			pstm1.setInt(2, estMemo1.getCodEstado());
			pstm1.setInt(3, estMemo1.getCodUsuarioRev());
			pstm1.setString(4, estMemo1.getFechaRegistrada());
			pstm1.setString(5, estMemo1.getHora());
			pstm1.setString(6, estMemo1.getObservacion());
			pstm1.setInt(7, estMemo1.getOrden());
			res = pstm1.executeUpdate();
			
			String sql2 = "INSERT INTO tb_estado_memo VALUES(?,?,?,?,?,?,?);";

			pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, estMemo2.getCodMemo());
			pstm2.setInt(2, estMemo2.getCodEstado());
			pstm2.setInt(3, estMemo2.getCodUsuarioRev());
			pstm2.setString(4, estMemo2.getFechaRegistrada());
			pstm2.setString(5, estMemo2.getHora());
			pstm2.setString(6, estMemo2.getObservacion());
			pstm2.setInt(7, estMemo2.getOrden());
			res = pstm2.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			System.out.println("Error al realizar la transaccion del estado del memo "+e.getMessage());
			res = 0;
			try {
				conn.rollback();
			} catch (Exception e2) {
				System.out.println("Error al restaurar "+e2.getMessage());
			}finally{
				try {
					if(conn != null)conn.close();
					if(pstm1 != null)pstm1.close();
					if(pstm2 != null)pstm2.close();
				} catch (SQLException e3) {
					System.out.println("Error al cerrar la base de datos "+e3.getMessage());
				}
			}
		}
		return res;
		
		
	}
	
	
	public ArrayList<ReporteEstadoMemo> reporteEstMemoxCodMemo(int codMemo) {
		ArrayList<ReporteEstadoMemo> lista =new ArrayList<ReporteEstadoMemo>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReporteEstadoMemo repEstMemo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call usp_EstadoMemoxIdMemo(?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, codMemo);
			res = pstm.executeQuery();
			while(res.next()) {
				repEstMemo = new ReporteEstadoMemo();
				repEstMemo.setCodMemo(res.getInt(1));
				repEstMemo.setDescEstado(res.getString(2));
				repEstMemo.setNomUsuarioRev(res.getString(3));
				repEstMemo.setFechaRegistrada(res.getString(4));
				repEstMemo.setHora(res.getString(5));
				repEstMemo.setObservacion(res.getString(6));
			
			lista.add(repEstMemo);
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
	
	public int numOrdenxCodMemo(int codMemo) {
		int codigo =0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet respuesta = null;
		
		try {
			String sql = "select max(orden_estado)from tb_estado_memo where id_memo =?;";
			conn = MySQLConexion8.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codMemo);
			respuesta = pstm.executeQuery();
			if(respuesta.next()) {
				codigo = respuesta.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - obtener el numero de ID Memorandum "+e.getMessage());
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
