package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.TipoUsuario;

import interfaces.TipoUsuarioInterfaceDAO;
import utils.MySQLConexion8;

public class GestionTipoUsuarioDAO implements TipoUsuarioInterfaceDAO {

	@Override
	public ArrayList<TipoUsuario> listarTipoUsuario() {
		
		ArrayList<TipoUsuario> lista =new ArrayList<TipoUsuario>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		TipoUsuario tipoUser = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select * from tb_tipos";
			pstm = con.prepareStatement(sql);
			
			res = pstm.executeQuery();
			while(res.next()) {
			tipoUser = new TipoUsuario();
			tipoUser.setIdTipo(res.getInt(1));
			tipoUser.setDescripTipo(res.getString(2));
			
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

}
