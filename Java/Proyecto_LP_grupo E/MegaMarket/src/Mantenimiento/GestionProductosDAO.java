package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.CategoriaProducto;
import Entidad.Productos;
import Interfaz.ProductosInterfacesDAO;
import utils.MySQLconexion8;

public class GestionProductosDAO implements ProductosInterfacesDAO {

	@Override
	public int registrarProducto(Productos p) {
		int res= 0;
		Connection con = null;
		PreparedStatement pstm=null;
	
		try {
			con= MySQLconexion8.getConexion();
			//			  insert into productos values (null,'Lavadora LG 15kg','24','1400','1','1')
			String sql = "insert into productos values (null, ?, ?, ?, ?, ?)";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getDescripcion());
			pstm.setInt(2, p.getStock());
			pstm.setDouble(3, p.getPrecio());
			pstm.setInt(4, p.getCategoriaProducto().getCodigo());
			pstm.setInt(5, p.getProveedor().getCodigo());

			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la intrucción SQL - Registrar" + e.getMessage());
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(con!=null) con.close();
				
			} catch (SQLException e2) {
			System.out.println("Error al cerrar la BD" + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int ActualizarProducto(Productos p) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLconexion8.getConexion();
			
			//           update productos set descripcion = 'Televisor Samsung 65 pulgadas',stock = '15', precio = '2100', id_categoria = '10', id_proveedor = '3' where idproductos = '2'
			String sql ="update productos set descripcion = ?,stock = ?, precio = ?, id_categoria = ?,id_proveedor = ? where idproductos = ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, p.getDescripcion());
			pstm.setInt(2, p.getStock());
			pstm.setDouble(3, p.getPrecio());
			pstm.setInt(4, p.getCategoriaProducto().getCodigo());
			pstm.setInt(5, p.getProveedor().getCodigo());
			pstm.setInt(6, p.getCodigo());

			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Actualizar producto"+e.getMessage());
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
	public int EliminarProducto(int codigo) {
		int res=0;
		Connection con=null;
		PreparedStatement pst= null;
		
		try {
			con = MySQLconexion8.getConexion();
			String sql= "delete from productos where idproductos = ?";
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
	public ArrayList<Productos> buscar(String descripcion, CategoriaProducto categoria) {
		Connection con = null;
	 	PreparedStatement pstm = null;
	 	ResultSet rs =null;
	 	Productos p = null;
	 	ArrayList<Productos> listaBusqueda = new ArrayList<Productos>();
	
		try {
			con =  MySQLconexion8.getConexion();
			String sql = "call usp_BuscarProducto(?,?)";
			
			pstm = con.prepareStatement(sql);
			
			
			pstm.setString(1,descripcion);						
			pstm.setInt(2, categoria.getCodigo());		
			
		    rs = pstm.executeQuery();
			while (rs.next()) {
				p = new Productos();  
				p.setCodigo(rs.getInt(1)); 
				p.setDescripcion(rs.getString(2));
				p.setStock(rs.getInt(3));
				p.setPrecio(rs.getDouble(4));
				p.setCategoriaProducto(new GestionCategoriaProductoDAO().obtener(rs.getInt(5)));
				p.setProveedor(new GestionProveedorDAO().obtener(rs.getInt(6)));

                listaBusqueda.add(p);      
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción buscar proveedor" + e.getMessage());
		} finally {
	        try {
	        	if (rs!= null)rs.close();
				if (pstm!= null)pstm.close(); 
				if (con!= null)con.close();
	        }catch (SQLException e2) { 
	        	System.out.println("Error al cerrar la BD"+e2.getMessage());
	        }
		} 
		return listaBusqueda;
	}

	@Override
	public Productos obtener(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Productos p = null;
		
		try {
			con = MySQLconexion8.getConexion();
			//			select idproductos,descripcion,stock,precio,id_categoria,id_proveedor from productos where idproductos ='2';;
			String sql="select idproductos,descripcion,stock,precio,id_categoria,id_proveedor from productos where idproductos =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				p = new Productos();  
				
				p.setCodigo(rs.getInt(1)); 
				p.setDescripcion(rs.getString(2));
				p.setStock(rs.getInt(3));
				p.setPrecio(rs.getDouble(4));
				p.setCategoriaProducto(new GestionCategoriaProductoDAO().obtener(rs.getInt(5)));
				p.setProveedor(new GestionProveedorDAO().obtener(rs.getInt(6)));

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
	public ArrayList<Productos> listarProductos() {
		Connection conn = null;
	 	PreparedStatement pstmt = null;
	 	ResultSet rs =null;
	 	Productos p = null;
	 	ArrayList<Productos> listaProductos = new ArrayList<Productos>();
 
		try {
			conn =  MySQLconexion8.getConexion();
			//					select idproductos, descripcion, stock, precio, id_categoria, id_proveedor from productos
			String selectSQL = "select idproductos, descripcion, stock, precio, id_categoria, id_proveedor from productos";
			pstmt = conn.prepareStatement(selectSQL);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				p = new Productos();  
				p.setCodigo(rs.getInt(1)); 
				p.setDescripcion(rs.getString(2));
				p.setStock(rs.getInt(3));
				p.setPrecio(rs.getDouble(4));
				p.setCategoriaProducto(new GestionCategoriaProductoDAO().obtener(rs.getInt(5)));
				p.setProveedor(new GestionProveedorDAO().obtener(rs.getInt(6)));

				listaProductos.add(p);    
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Listar" + e.getMessage());
		} finally {
            try {
            	if (rs!= null)    rs.close();
				if (pstmt!= null) pstmt.close(); 
				if (conn!= null)  conn.close();
            }catch (Exception e2) { 
            	System.out.println("Error al cerrar la BD"+e2.getMessage());
            }
		} 
		return listaProductos;
	}

}
