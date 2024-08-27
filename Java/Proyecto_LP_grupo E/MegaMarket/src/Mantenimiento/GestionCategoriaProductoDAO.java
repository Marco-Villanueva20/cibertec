package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.CategoriaProducto;
import Interfaz.CategoriaInterfacesDAO;
import utils.MySQLconexion8;

public class GestionCategoriaProductoDAO implements CategoriaInterfacesDAO{

	@Override
	public ArrayList<CategoriaProducto> listar() {
		Connection con = null;
	 	PreparedStatement pstmt = null;
	 	ResultSet rs =null;
	 	CategoriaProducto categoria = null;
	 	ArrayList<CategoriaProducto> listaCategoria = new ArrayList<CategoriaProducto>();
 
		try {
			con =  MySQLconexion8.getConexion();
			//					select idcategoria, nombre_categoria from categoria_producto
			String selectSQL = "select idcategoria, nombre_categoria from categoria_producto";
			pstmt = con.prepareStatement(selectSQL);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				categoria = new CategoriaProducto();
				
				categoria.setCodigo(rs.getInt(1)); 
				categoria.setDescripcion(rs.getString(2));
				
				listaCategoria.add(categoria);    
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
		return listaCategoria;
	}

	@Override
	public CategoriaProducto obtener(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CategoriaProducto cp = null;
		
		try {
			con = MySQLconexion8.getConexion();
			//			select idcategoria, nombre_categoria from categoria_producto where idcategoria = '2';
			String sql="select idcategoria, nombre_categoria from categoria_producto where idcategoria = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				cp = new CategoriaProducto();  
				cp.setCodigo(rs.getInt(1)); 
				cp.setDescripcion(rs.getString(2));


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

	return cp;
	
	}
}
