package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Proveedor;
import Interfaz.ProveedorInterfacesDAO;
import utils.MySQLconexion8;

public class GestionProveedorDAO implements ProveedorInterfacesDAO{

	@Override
	public int registrarProveedor(Proveedor p) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con=MySQLconexion8.getConexion();
			
			//INSERT INTO proveedores VALUES(null,'Lg Electronics Peru','20375755344','lgElectronics@lg.com.pe');
			String sql = "insert into proveedores values (null,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getRuc());
			pstm.setString(3, p.getDireccion());

			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción Registrar proveedor"+e.getMessage());
		}finally {
			try {
				if(pstm !=null)pstm.close();
				if(con!=null)con.close();
			}catch (SQLException e2) {
				System.out.println("Error al cerrar la BD" +e2.getMessage());
			}
		}

		return res;
	}

	@Override
	public int ActualizarProveedor(Proveedor p) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLconexion8.getConexion();
			
			//           update proveedores set rsocial = "Mabe",ruc = "20214569845",direccion = "av aviacion " where idproveedor = 2
			String sql ="update proveedores set rsocial = ?,ruc = ?, direccion = ? where idproveedor = ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getRuc());
			pstm.setString(3, p.getDireccion());
			pstm.setInt(4, p.getCodigo());

			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Actualizar proveedor"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(con != null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD"+e2.getMessage());
			}
		}
		
		return res;
	}

	@Override
	public int EliminarProveedor(int codigo) {
		int res=0;
		Connection con=null;
		PreparedStatement pst= null;
		
		try {
			con = MySQLconexion8.getConexion();
			String sql= "delete from proveedores where idproveedor = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, codigo);
			res = pst.executeUpdate();
		} catch (Exception e) {
		System.out.println("Error en la instrucción SQL - Eliminar" + e.getMessage());
		}finally {
			try {
				if (pst!=null) pst.close();
				if (con!=null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD"+e2.getMessage());
			}
		}
		
		return res;
	}
	
	@Override
	public ArrayList<Proveedor> buscar(String busqueda) {
		Connection con = null;
	 	PreparedStatement pstm = null;
	 	ResultSet rs =null;
	 	Proveedor p = null;
	 	ArrayList<Proveedor> listaProveedor = new ArrayList<Proveedor>();
	
		try {
			con =  MySQLconexion8.getConexion();
			String sql = "call usp_BuscarProveedor(?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, busqueda);
							
		    rs = pstm.executeQuery();
		    
			while (rs.next()) {
				p = new Proveedor();  
				p.setCodigo(rs.getInt(1)); 
				p.setNombre(rs.getString(2));
				p.setRuc(rs.getString(3));
				p.setDireccion(rs.getString(4));

				listaProveedor.add(p);    
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Listar proveedor " + e.getMessage());
		} finally {
	        try {
	        	if (rs!= null)rs.close();
				if (pstm!= null)pstm.close(); 
				if (con!= null)con.close();
	        }catch (SQLException e2) { 
	        	System.out.println("Error al cerrar la BD"+e2.getMessage());
	        }
		} 
		return listaProveedor;
	}
	
	@Override
	public Proveedor obtener(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Proveedor p = null;
		
		try {
			con = MySQLconexion8.getConexion();
			//			select idproveedor,rsocial,ruc,direccion from proveedores where idproveedor ='1';
			String sql="select idproveedor,rsocial,ruc,direccion from proveedores where idproveedor = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				p = new Proveedor();  
				p.setCodigo(rs.getInt(1)); 
				p.setNombre(rs.getString(2));
				p.setRuc(rs.getString(3));
				p.setDireccion(rs.getString(4));;

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
	
		return p;
	
}

	@Override
	public ArrayList<Proveedor> ListarProveedor() {
		ArrayList<Proveedor> listaprov = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Proveedor prov = null;

		try {
			con = MySQLconexion8.getConexion();
			//           select idcategoria, nombre_categoria from categoria_producto
			String sql = "select idproveedor, rsocial, ruc, direccion from proveedores";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {
				prov = new Proveedor();
				prov.setCodigo(res.getInt(1));
				prov.setNombre(res.getString(2));
				prov.setRuc(res.getString(3));
				prov.setDireccion(res.getString(4));

				listaprov.add(prov);
			}

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Listar Proveedores" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD" + e2.getMessage());
			}
		}

		return listaprov;
	}



}
