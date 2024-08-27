package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.ReporteIdUsuario;
import entidad.TipoProducto;
import interfaces.TipoProductoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTipoProductoDAO implements TipoProductoInterfacesDAO {

	@Override
	public ArrayList<TipoProducto> listarTipoProducto() {
			
			ArrayList<TipoProducto> lista =new ArrayList<TipoProducto>();
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet res = null;
			TipoProducto tipoUser = null;
			try {
				con = MySQLConexion8.getConexion();
				String sql = "select * from tb_categorias";
				pstm = con.prepareStatement(sql);
				
				res = pstm.executeQuery();
				while(res.next()) {
				tipoUser = new TipoProducto();
				tipoUser.setCodigo(res.getInt(1));
				tipoUser.setDecripcion(res.getString(2));
				
				lista.add(tipoUser);
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
	public ReporteIdUsuario reportexId(String codigo) {
		ReporteIdUsuario user = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// paso 1 --> conectar a la BD
			con = MySQLConexion8.getConexion();
			// paso 2 --> Establecer la instruccion SQL - Consulta de usurio po codigo
			String sql = "call usp_listarusuarioxId({call usp_listarusuarioxId(?)})";
			// paso 3 --> Enviar la instruccion SQL al objeto pstm
			pstm = con.prepareStatement(sql);
			// paso 4 --> parametros
			pstm.setString(1, codigo);
			// paso 5 --> ejecutar la consulta
			res = pstm.executeQuery();
			// paso 6 --> Setear los valores
			if (res.next()) {
				user = new ReporteIdUsuario(
						res.getString(1), 
						res.getDouble(2),
						res.getInt(3)
						);
			}
		} catch (Exception e) {
			System.out.println("Error en la consulta de búsqueda " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}

		return user;
	}

}
