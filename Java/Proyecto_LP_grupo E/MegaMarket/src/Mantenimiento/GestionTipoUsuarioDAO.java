package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.TipoUsuario;
import Interfaz.TipoUsuarioInterfaceDAO;
import utils.MySQLconexion8;

public class GestionTipoUsuarioDAO implements TipoUsuarioInterfaceDAO {

	@Override
	public ArrayList<TipoUsuario> listar() {
		Connection con = null;
	 	PreparedStatement pstmt = null;
	 	ResultSet rs =null;
	 	TipoUsuario tipoUser = null;
	 	ArrayList<TipoUsuario> listaTipoUser = new ArrayList<TipoUsuario>();
 
		try {
			con =  MySQLconexion8.getConexion();
			//					select idtipo_usuarios, nombre from tipo_usuarios
			String selectSQL = "select idtipo_usuarios, nombre from tipo_usuarios";
			pstmt = con.prepareStatement(selectSQL);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				tipoUser = new TipoUsuario();
				
				tipoUser.setCodigo(rs.getInt(1)); 
				tipoUser.setDescripcion(rs.getString(2));
				
				listaTipoUser.add(tipoUser);    
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Listar" + e.getMessage());
		} finally {
            try {
            	if (rs!= null)    rs.close();
				if (pstmt!= null) pstmt.close(); 
				if (con!= null)  con.close();
            }catch (SQLException e2) { 
            	System.out.println("Error al cerrar la BD" +e2.getMessage());
            }
		} 
		return listaTipoUser;
	}

	@Override
	public TipoUsuario obtener(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TipoUsuario tipoUser = null;
		
		try {
			con = MySQLconexion8.getConexion();
			//			  select idtipo_usuarios, nombre from tipo_usuarios where idtipo_usuarios = '2';
			String sql = "select idtipo_usuarios, nombre from tipo_usuarios where idtipo_usuarios = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				tipoUser = new TipoUsuario();  
				tipoUser.setCodigo(rs.getInt(1)); 
				tipoUser.setDescripcion(rs.getString(2));


			}
		} catch (Exception e) {
		System.out.println("Error en la instrucción SQL - Obtener " + e.getMessage());
	}finally {
		try {		
			if (rs!=null) 	rs.close();
			if (con!=null) con.close();
			if (pstmt!=null) pstmt.close();
			
			
		} catch (SQLException e2) {
			System.out.println("Error al cerrar la BD"+e2.getMessage());
		}
	}

	return tipoUser;
	}

}
