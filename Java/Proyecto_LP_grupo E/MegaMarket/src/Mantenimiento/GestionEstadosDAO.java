package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Estados;
import Interfaz.EstadosInterfacesDAO;
import utils.MySQLconexion8;

public class GestionEstadosDAO implements EstadosInterfacesDAO{

	@Override
	public ArrayList<Estados> listar() {
		Connection con = null;
	 	PreparedStatement pstmt = null;
	 	ResultSet rs =null;
	 	Estados estado = null;
	 	ArrayList<Estados> listaEstados = new ArrayList<Estados>();
 
		try {
			con =  MySQLconexion8.getConexion();
			//					select id_estado, descripcion from estados
			String selectSQL = "select id_estado, descripcion from estados";
			pstmt = con.prepareStatement(selectSQL);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				estado = new Estados();
				
				estado.setCodigo(rs.getInt(1)); 
				estado.setDescripcion(rs.getString(2));
				
				listaEstados.add(estado);    
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Listar estados" + e.getMessage());
		} finally {
            try {
            	if (rs!= null)    rs.close();
				if (pstmt!= null) pstmt.close(); 
				if (con!= null)  con.close();
            }catch (SQLException e2) { 
            	System.out.println("Error al cerrar la BD" +e2.getMessage());
            }
		} 
		return listaEstados;
	}

	@Override
	public Estados obtener(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Estados estado = null;
		
		try {
			con = MySQLconexion8.getConexion();
			//select idestado, descripcion from estados where idestado = '1';
			String sql = " select id_estado, descripcion from estados where id_estado = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				estado = new Estados();  
				estado.setCodigo(rs.getInt(1)); 
				estado.setDescripcion(rs.getString(2));


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

	return estado;
	}

}
