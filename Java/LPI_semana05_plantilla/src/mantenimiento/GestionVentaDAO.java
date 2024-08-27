package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.CabeceraBoleta;
import entidad.DetalleBoleta;
import interfaces.VentasInterfacesDAO;
import utils.MySQLConexion8;

public class GestionVentaDAO implements VentasInterfacesDAO {

	@Override
	public String numBoleta() {
		String codigo = "B0001";
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "select substring(max(num_bol),2) from tb_cab_boleta;";
			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();
			if (res.next()) {
				DecimalFormat df = new DecimalFormat("0000");
				codigo = "B" + df.format(Integer.parseInt(res.getString(1)) + 1);

			}

		} catch (Exception e) {
			System.out.println("Error al generar el Nro de Boleta" + e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (res != null) {
					res.close();
				}
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos");
			}
		}
		return codigo;
	}

	@Override
	public int realizarVenta(CabeceraBoleta cBol, ArrayList<DetalleBoleta> dBol) {
		int estado = 0;
		PreparedStatement pstm1 = null;/// registro en cab_boleta
		PreparedStatement pstm2 = null;// registro en tb_boleta
		PreparedStatement pstm3 = null;// actualizar la tb_productos s --tock
		Connection con = null;

		try {
			// paso 1
			con = MySQLConexion8.getConexion();
			// paso 2 // desactivar la config automatica
			con.setAutoCommit(false);
			// instruccion 1 registrar los datos en la tabla tb_cabecera_boleta
			String sql1 = "INSERT INTO tb_cab_boleta VALUES(?,?,?,?,?);";
			//
			pstm1 = con.prepareStatement(sql1);
			// parametros
			pstm1.setString(1, cBol.getNumBoleta());
			pstm1.setString(2, cBol.getFechaBol());
			pstm1.setInt(3, cBol.getCodCliente());
			pstm1.setInt(4, cBol.getCodVendedor());
			pstm1.setDouble(5, cBol.getImpTotalBoleta());
			estado = pstm1.executeUpdate();
			// Intruccion 2 registrar los datos en la tabla detalle boleta
			String sql2 = "INSERT INTO tb_det_boleta VALUES(?,?,?,?,?)";
			for (DetalleBoleta detBoleta : dBol) {
				pstm2 = con.prepareStatement(sql2);
				pstm2.setString(1, cBol.getNumBoleta());
				pstm2.setString(2, detBoleta.getIdProd());
				pstm2.setInt(3, detBoleta.getCantidad());
				pstm2.setDouble(4, detBoleta.getPrecioVenta());
				pstm2.setDouble(5, detBoleta.getImporte());
				estado = pstm2.executeUpdate();
			}
			// Instrucción 3 Actualizar la tabla productos
			String sql3 = " UPDATE tb_productos set stock = stock - ? where idprod = ?";
			for (DetalleBoleta detBoleta : dBol) {
				pstm3 = con.prepareStatement(sql3);
				pstm3.setInt(1, detBoleta.getCantidad());
				pstm3.setString(2, detBoleta.getIdProd());
				estado = pstm3.executeUpdate();
			}

			// CONFIRMAR TRANSACCION
			con.commit();

		} catch (Exception e) {
			System.out.println("Error al realizar la venta " + e.getMessage());
			estado = 0;
			try {
				// restaura la base de datos
				con.rollback();
			} catch (Exception e2) {
				System.out.println("Error al restaurar " + e2.getMessage());
			} finally {
				try {
					if (con != null)con.close();
					if (pstm1 != null)pstm1.close();
					if (pstm2 != null)pstm2.close();
					if (pstm3 != null)pstm3.close();
				} catch (Exception e3) {
					System.out.println("Error al cerrar la BD " + e3.getMessage());
				}
			}
		}
		return estado;
	}

}
