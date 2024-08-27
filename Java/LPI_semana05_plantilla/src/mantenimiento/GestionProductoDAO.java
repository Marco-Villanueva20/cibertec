package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Producto;
import entidad.ReporteIdProducto;
import interfaces.ProductoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionProductoDAO implements ProductoInterfacesDAO {

	@Override
	public int registrar(Producto prod) {
		//Declaración de Variable
				int res = 0;
				Connection con = null;
				PreparedStatement pstm = null;	
				try {
					//Paso 1 :Establecer la conexion de la base de datos
					con = MySQLConexion8.getConexion();
					//Paso 2: Establecer la instruccion SQL -- Registrar
					String sql = "insert into tb_productos values(?,?,?,?,?,?)";
					//Paso 3: Crear el objeto pstm y enviar la variable sql
					pstm = con.prepareStatement(sql);//obtener comandos sql
					//Paso 4 : Obtener los parametros de ingreso
					pstm.setString(1, prod.getIdProd());
					pstm.setString(2, prod.getDescripProducto());
					pstm.setInt(3, prod.getStock());
					pstm.setDouble(4, prod.getPrecio());
					pstm.setInt(5, prod.getIdTipo());
					pstm.setInt(6, prod.getEstado());
					//Pao 5: ejecutar la instruccion
					res = pstm.executeUpdate();
					
				} catch (Exception e) {
					System.out.println(" >>>> Error en la instrucción SQL - Registrar "+ e.getMessage());
				}finally {
					try {
						if(pstm != null)pstm.close();
						if(con != null)con.close();
					} catch (SQLException e2) {
						System.out.println("<< Error al cerrar la base de datos "+e2.getMessage());
					}
				}
				
				return res;
	}

	@Override
	public int actualizar(Producto prod) {
int res = 0;
		
		Connection  con = null;
		PreparedStatement pstm = null;
		try {
			//paso 1: establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			//paso 2: establecer la instruccion SQL -- para eliminar
			String sql = "update  tb_productos set descripcion= ?, stock= ?, precio= ?,idtipo= ?,estado= ? where idprod = ?";
			//paso 3 --> enviar la instrucción al objeto pstm -- para obtener los comandos sql
			pstm = con.prepareStatement(sql);
			//paso 4 -- obtener el parametro =  ?;
			pstm.setString(1, prod.getDescripProducto());
			pstm.setInt(2, prod.getStock());
			pstm.setDouble(3, prod.getPrecio());
			pstm.setInt(4, prod.getIdTipo());
			pstm.setInt(5, prod.getEstado());
			pstm.setString(6, prod.getIdProd());
		
			//paso 5 -- ejecutar la instruccion sql
			res = pstm.executeUpdate();
		}catch(Exception e){
			System.out.println("Error en la instruccion SQL - Actualizar: "+e.getMessage());
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(con !=null)   con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
			
		}return res;
	}

	@Override
	public ArrayList<Producto> listarProductos() {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Producto prod = null;
		
		try {
			//paso 1 conectar a la base de datos
			con = MySQLConexion8.getConexion();
			//paso 2 establecer la instruccion sql
			String sql = "SELECT * FROM ciberfarma.tb_productos;";
			//paso 3 
			pstm = con.prepareStatement(sql);
			//paso 4 --> no se necesita
			
			//paso 5 ejecutar la instruccion sql
			res = pstm.executeQuery();
			//paso 6 bucle para realizar el recorrido al objeto res
			while(res.next()) {
				//Crear objeto de tipo Usuario
				prod = new Producto();
	            //setear(asignar los valores a los atributos privados
				prod.setIdProd(res.getString(1)); 
				prod.setDescripProducto(res.getString(2));
				prod.setStock(res.getInt(3)); 
				prod.setPrecio(res.getDouble(4));
				prod.setIdTipo(res.getInt(5));
				prod.setEstado(res.getInt(6));
	            
	        //7 añadir el usuario a la lista
	            lista.add(prod);
	        }
			
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL");
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res !=null)res.close();
				if(con != null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		
		return lista ;
	}

	
	@Override
	public int eliminiar(String codigo) {
		int res = 0;

		Connection con = null;
		PreparedStatement pstm = null;
		try {
			// paso 1: establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2: establecer la instruccion SQL -- para eliminar
			String sql = "delete from tb_productos where tb_productos.idprod = ?";
			// paso 3 --> enviar la instrucción al objeto pstm -- para obtener los comandos
			// sql
			pstm = con.prepareStatement(sql);
			// paso 4 -- obtener el parametro = ?;
			pstm.setString(1, codigo);

			// paso 5 -- ejecutar la instruccion sql
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Eliminar: " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return res;
	}

	@Override
	public ArrayList<ReporteIdProducto> bucarProducto(String codigo) {
		ArrayList<ReporteIdProducto> lista = new ArrayList<ReporteIdProducto>();
		ReporteIdProducto repProd = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
	
		
		try {
			//paso 1 conectar a la base de datos
			con = MySQLConexion8.getConexion();
			//paso 2 establecer la instruccion sql
			String sql = "call usp_listarusuarioxId(?);";
			//paso 3 
			pstm = con.prepareStatement(sql);
			//paso 4 --> 
			pstm.setString(1, codigo);
			//paso 5 ejecutar la instruccion sql
			res = pstm.executeQuery();
			//paso 6 bucle para realizar el recorrido al objeto res
			while(res.next()) {
				//Crear objeto de tipo Usuario
				repProd = new ReporteIdProducto();
	            //setear(asignar los valores a los atributos privados
				repProd.setNombre(res.getString(1));
				repProd.setPrecio(res.getDouble(2));
				repProd.setStock(res.getInt(3)); 
	            
	        //7 añadir el usuario a la lista
	            lista.add(repProd);
	        }
			
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL");
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res !=null)res.close();
				if(con != null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		
		return lista ;}

	@Override
	public Producto buscar(String buscarProd) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Producto prod = null;
		try {
			// paso 1: establecer la conexion a la base de datos
			con = MySQLConexion8.getConexion();
			// paso 2: establecer la instruccion SQL -- para buscar
			String sql = "select * from tb_productos where tb_productos.idprod = ?";
			// paso 3 --> enviar la instrucción al objeto pstm -- para obtener los comandos
			// sql
			pstm = con.prepareStatement(sql);
			// paso 4 -- obtener el parametro = ?;
			pstm.setString(1, buscarProd);

			// paso 5 -- ejecutar la instruccion sql y obtener los resultados
			res = pstm.executeQuery();
			
			// paso 6 -- procesar los resultados y crear el objeto Producto
			if (res.next()) {
				prod = new Producto();
	            //setear(asignar los valores a los atributos privados
				prod.setIdProd(res.getString(1)); 
				prod.setDescripProducto(res.getString(2));
				prod.setStock(res.getInt(3)); 
				prod.setPrecio(res.getDouble(4));
				prod.setIdTipo(res.getInt(5));
				prod.setEstado(res.getInt(6));
			}
		} catch (Exception e) {
			System.out.println("Error en la instruccion SQL - Buscar: " + e.getMessage());
		} finally {
			try {
				if (res != null)
					res.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return prod;
	}

	@Override
	public ArrayList<Producto> listar(String nomProd) {
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Producto prod = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
	
		
		try {
			
			con = MySQLConexion8.getConexion();
			
			String sql = "{call usp_buscarProd(?)}";
	
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, nomProd);
			
			res = pstm.executeQuery();
			
			while(res.next()) {
				
				prod = new Producto();
				prod.setIdProd(res.getString(1));
				prod.setDescripProducto(res.getString(2));
				prod.setStock(res.getInt(3));
				prod.setPrecio(res.getDouble(4));
				prod.setIdTipo(res.getInt(5));
				prod.setEstado(res.getInt(6));
	            
	        //7 añadir el usuario a la lista
	            lista.add(prod);
	        }
			
			
		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL");
		}finally {
			try {
				if(pstm != null)pstm.close();
				if(res !=null)res.close();
				if(con != null)con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos "+e2.getMessage());
			}
		}
		
		return lista ;
	}

	}

