package Mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidad.Usuarios;
import Interfaz.UsuariosInterfacesDAO;
import utils.MySQLconexion8;

public class GestionUsuarios implements UsuariosInterfacesDAO{

	@Override
	public int registrar(Usuarios u) {
		int res= 0;
		Connection con = null;
		PreparedStatement pstm=null;
	
		try {
			con= MySQLconexion8.getConexion();
			//			  insert into usuarios values (null,'jparedes','Wallet45','1','1')
			String sql = "insert into usuarios values (null,?,?,?,?)";
			
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getPass());
			pstm.setInt(3, u.getTipousuario().getCodigo());
			pstm.setInt(4, u.getEstado().getCodigo());

			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la intrucción SQL - Registrar Usuario" + e.getMessage());
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
	public int ActualizarUsuario(Usuarios u) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLconexion8.getConexion();
			
			//           update usuarios set nombre_usuario = 'Vgonzales',password = 'Cercol12', idtipo_usuario = '2', id_estado = '2' where idusuarios = '1'
			String sql ="update usuarios set nombre_usuario = ?,password = ?, idtipo_usuario = ?, id_estado = ? where idusuarios = ?";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getPass());
			pstm.setInt(3, u.getTipousuario().getCodigo());
			pstm.setInt(4, u.getEstado().getCodigo());
			pstm.setInt(5, u.getCodigo());

			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Actualizar Usuario"+e.getMessage());
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
	public int EliminarUsuario(int codigo) {
		int res=0;
		Connection con=null;
		PreparedStatement pst= null;
		
		try {
			con = MySQLconexion8.getConexion();
			String sql= "delete from usuarios where idusuarios = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, codigo);
			res = pst.executeUpdate();
		} catch (Exception e) {
		System.out.println("Error en la instrucción SQL - Eliminar Usuarios" + e.getMessage());
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
	public ArrayList<Usuarios> buscar(String busqueda) {
		Connection con = null;
	 	PreparedStatement pstm = null;
	 	ResultSet rs =null;
	 	Usuarios u = null;
	 	ArrayList<Usuarios> listaBusqueda = new ArrayList<Usuarios>();
	
		try {
			con =  MySQLconexion8.getConexion();
			String sql = "call usp_BuscarUsuario(?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, busqueda);
	
		    rs = pstm.executeQuery();
		    
			while (rs.next()) {
				u = new Usuarios();  
				u.setCodigo(rs.getInt(1)); 
				u.setNombre(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setTipousuario(new GestionTipoUsuarioDAO().obtener(rs.getInt(4)));
				u.setEstado(new GestionEstadosDAO().obtener(rs.getInt(5)));

				listaBusqueda.add(u);    
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción buscar Usuario" + e.getMessage());
		} finally {
	        try {
	        	if (rs!= null) rs.close();
				if (pstm!= null)pstm.close(); 
				if (con!= null)con.close();
	        }catch (SQLException e2) { 
	        	System.out.println("Error al cerrar la BD"+e2.getMessage());
	        }
		} 
		return listaBusqueda;
	}

	@Override
	public Usuarios obtener(int codigo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Usuarios u = null;
		
		try {
			con = MySQLconexion8.getConexion();
			//			select idusuarios,nombre_usuario,password,id_tipousuario,id_estado from usuarios where idusuarios ='1';
			String sql="select idusuarios,nombre_usuario,password,idtipo_usuario,id_estado from usuarios where idusuarios = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				u = new Usuarios();  
				
				u.setCodigo(rs.getInt(1)); 
				u.setNombre(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setTipousuario(new GestionTipoUsuarioDAO().obtener(rs.getInt(4)));
				u.setEstado(new GestionEstadosDAO().obtener(rs.getInt(5)));

			}
	
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Obtener Usuario " + e.getMessage());
		}finally {
			try {		
				if (rs!=null) 	rs.close();
				if (con!=null) con.close();
				if (pstmt!=null) pstmt.close();
				
				
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD"+e2.getMessage());
			}
		}
	
		return u;
	}

	@Override
	public ArrayList<Usuarios> listarUsuario() {
		Connection conn = null;
	 	PreparedStatement pstmt = null;
	 	ResultSet rs =null;
	 	Usuarios u = null;
	 	ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
 
		try {
			conn =  MySQLconexion8.getConexion();
			//					select idusuarios, nombre_usuario, password, id_tipo_usuario, id_estado from usuarios
			String selectSQL = "select idusuarios, nombre_usuario, password, idtipo_usuario, id_estado from usuarios";
			pstmt = conn.prepareStatement(selectSQL);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				u = new Usuarios();  
				u.setCodigo(rs.getInt(1)); 
				u.setNombre(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setTipousuario(new GestionTipoUsuarioDAO().obtener(rs.getInt(4)));
				u.setEstado(new GestionEstadosDAO().obtener(rs.getInt(5)));

				listaUsuarios.add(u);    
			}
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Listar Usuarios" + e.getMessage());
		} finally {
            try {
            	if (rs!= null)    rs.close();
				if (pstmt!= null) pstmt.close(); 
				if (conn!= null)  conn.close();
            }catch (Exception e2) { 
            	System.out.println("Error al cerrar la BD"+e2.getMessage());
            }
		} 
		return listaUsuarios;
	}

	@Override
	public Usuarios validarAcceso(String user, String pass) {
		Usuarios usuario = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//1
			con = MySQLconexion8.getConexion();
			
			//2
			String sql = "{call usp_validarAcceso(?,?)}";
			
			//3
			pstm = con.prepareStatement(sql);
			
			//4
			pstm.setString(1, user);
			pstm.setString(2, pass);
			
			//5
			rs = pstm.executeQuery();
			
			//6
			while (rs.next()) {
			usuario = new Usuarios();  
				
			usuario.setCodigo(rs.getInt(1)); 
			usuario.setNombre(rs.getString(2));
			usuario.setPass(rs.getString(3));
			usuario.setTipousuario(new GestionTipoUsuarioDAO().obtener(rs.getInt(4)));
			usuario.setEstado(new GestionEstadosDAO().obtener(rs.getInt(5)));

			}
			
		} catch (Exception e) {
			System.out.println("Error en el procedimiento almacenado validar acceso"+e.getMessage());
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(rs != null)rs.close();
				if(con != null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerra la BD");
			}
		}
		return usuario;
	}

	
}
