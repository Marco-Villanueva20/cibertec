package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.EstadoMemo;
import entidad.Memorandum;
import entidad.ReporteMemorandum;
import entidad.ReporteVariosMemorandum;
import interfaces.MemorandumInterfacesDAO;
import utils.MySQLConexion8;

public class GestionMemorandumDAO implements MemorandumInterfacesDAO{

	public int enviarMemo(Memorandum memo , EstadoMemo estMemo) {
		int estado = 0;
		PreparedStatement pstm1 = null;
		PreparedStatement pstm2 = null;
		Connection conn = null;
		
		try {
			conn = MySQLConexion8.getConexion();
			conn.setAutoCommit(false);
			String sql1 = "INSERT INTO tb_memo VALUES(?,?,?,?,?,?);";
			String sql2 = "INSERT INTO tb_estado_memo VALUES(?,?,?,?,?,DEFAULT,?);";
			pstm1 = conn.prepareStatement(sql1);
			pstm1.setInt(1, memo.getCodigo());
			pstm1.setInt(2, memo.getUsuarioEmisor());
			pstm1.setInt(3, memo.getUsuarioReceptor());
			pstm1.setString(4, memo.getFecha());
			pstm1.setString(5, memo.getDescripcion());
			pstm1.setString(6, memo.getAsunto());
			
			estado = pstm1.executeUpdate();
			
			pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, memo.getCodigo());
			pstm2.setInt(2, estMemo.getCodEstado());
			pstm2.setInt(3, estMemo.getCodUsuarioRev());
			pstm2.setString(4, estMemo.getFechaRegistrada());
			pstm2.setString(5, estMemo.getHora());
			pstm2.setInt(6, estMemo.getOrden());
			estado = pstm2.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			System.out.println("Error al realizar el envio del memorandum "+e.getMessage());
			estado = 0;
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
		return estado;
		
	}
	
	public int numIdMemorandum() {
		int codigo =0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet respuesta = null;
		
		try {
			String sql = "select max(cod_memo)from tb_memo;";
			conn = MySQLConexion8.getConexion();
			pstm = conn.prepareStatement(sql);
			respuesta = pstm.executeQuery();
			if(respuesta.next()) {
				codigo = respuesta.getInt(1)+1;
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


	@Override
	public ReporteMemorandum reporteMemo(int cod) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReporteMemorandum repMemo = null;
		try {
			String sql = "{call bd_memoradum.usp_BuscarMemoxCod(?)}";
			conn = MySQLConexion8.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cod);
			res = pstm.executeQuery();
			if(res.next()) {
				repMemo = new ReporteMemorandum();
				repMemo.setCodigo(res.getInt(1));
				repMemo.setEmisor(res.getString(2));
				repMemo.setEmiCarArea(res.getString(3));
				repMemo.setReceptor(res.getString(4));		
				repMemo.setRecCarArea(res.getString(5));
				repMemo.setFecha(res.getString(6));	
				repMemo.setAsunto(res.getString(7));
				repMemo.setDescripcion(res.getString(8));
					
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - reporteMemo "+e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(pstm!=null)pstm.close();
				if(res!=null)res.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD "+e2.getMessage());
			}
		}
		return repMemo;
	}

	@Override
	public ArrayList<ReporteMemorandum> listarMemorandumx(int emisor, String codMemo, String nombreCompleto, String asunto,
			String fecha) {
		ArrayList<ReporteMemorandum> lista =new ArrayList<ReporteMemorandum>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReporteMemorandum reporteMemo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call bd_memoradum.usp_buscarMemox5Parametros(?,?,?,?,?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, emisor);
			pstm.setString(2, codMemo);
			pstm.setString(3, nombreCompleto);
			pstm.setString(4, asunto);
			pstm.setString(5, fecha);
			res = pstm.executeQuery();
			while(res.next()) {
				reporteMemo = new ReporteMemorandum();
				reporteMemo.setCodigo(res.getInt(1));
				reporteMemo.setEmisor(res.getString(2));
				reporteMemo.setReceptor(res.getString(3));
				reporteMemo.setAsunto(res.getString(4));
				reporteMemo.setFecha(res.getString(5));
			lista.add(reporteMemo);
			}
			
		} catch (Exception e) {
			System.out.println(">> Error en la instruccion SQL - Listar Memo por 5 parametros "+e.getMessage());
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
	public ArrayList<ReporteMemorandum> listarMemorandumxEmisor(int emisor) {
		ArrayList<ReporteMemorandum> lista =new ArrayList<ReporteMemorandum>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReporteMemorandum reporteMemo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call bd_memoradum.usp_Listar_MemoxEmisor(?)}";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, emisor);
			
			res = pstm.executeQuery();
			while(res.next()) {
				reporteMemo = new ReporteMemorandum();
				reporteMemo.setCodigo(res.getInt(1));
				reporteMemo.setEmisor(res.getString(2));
				reporteMemo.setReceptor(res.getString(3));
				reporteMemo.setAsunto(res.getString(4));
				reporteMemo.setFecha(res.getString(5));
			lista.add(reporteMemo);
			}
			
		} catch (Exception e) {
			System.out.println(">> Error en la instruccion SQL - Listar Reporte Memo por Emisor "+e.getMessage());
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
	public ArrayList<ReporteVariosMemorandum> reportarVariosMemos() {
		ArrayList<ReporteVariosMemorandum> lista =new ArrayList<ReporteVariosMemorandum>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReporteVariosMemorandum reporteMemo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call bd_memoradum.usp_reporteMemos()}";
			pstm = con.prepareStatement(sql);
			res = pstm.executeQuery();
			while(res.next()) {
				reporteMemo = new ReporteVariosMemorandum();
				reporteMemo.setCodigo(res.getInt(1));
				reporteMemo.setRemitente(res.getString(2));
				reporteMemo.setDestinatario(res.getString(3));
				reporteMemo.setFecha(res.getString(4));
				reporteMemo.setAsunto(res.getString(5));
			lista.add(reporteMemo);
			}
			
		} catch (Exception e) {
			System.out.println(">> Error en la instruccion SQL - Listar Reporte Memos "+e.getMessage());
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
	public ArrayList<ReporteVariosMemorandum> reportarVariosMemosxFecha(String fecha) {
		ArrayList<ReporteVariosMemorandum> lista =new ArrayList<ReporteVariosMemorandum>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReporteVariosMemorandum reporteMemo = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call bd_memoradum.usp_reporteMemosxFecha(?)}";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, fecha);
			res = pstm.executeQuery();
			while(res.next()) {
				reporteMemo = new ReporteVariosMemorandum();
				reporteMemo.setCodigo(res.getInt(1));
				reporteMemo.setRemitente(res.getString(2));
				reporteMemo.setDestinatario(res.getString(3));
				reporteMemo.setFecha(res.getString(4));
				reporteMemo.setAsunto(res.getString(5));
			lista.add(reporteMemo);
			}
			
		} catch (Exception e) {
			System.out.println(">> Error en la instruccion SQL - Listar Reporte Memos por fecha "+e.getMessage());
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
	}

