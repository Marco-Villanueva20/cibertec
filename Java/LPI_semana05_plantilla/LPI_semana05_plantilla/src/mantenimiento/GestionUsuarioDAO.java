package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidad.Usuario;
import interfaces.UsuarioInterfacesDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfacesDAO {

	@Override
	public int registrar(Usuario u) {
		//Declaración de Variable
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//Paso 1 :Establecer la conexion de la base de datos
			con = MySQLConexion8.getConexion();
			//Paso 2: Establecer la instruccion SQL -- Registrar
			String sql = "insert into tb_usuarios values(null,?,?,?,?,?,default,default)";
			//Paso 3: Crear el objeto pstm y enviar la variable sql
			pstm = con.prepareStatement(sql);//obtener comandos sql
			//Paso 4 : Obtener los parametros de ingreso
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setString(2, u.getFechNacimiento());
			
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
	
	
}
