package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconexion8 {
	
	//Método estatico encargado de realizar la conexion a la bd "ciberfarna"
	public static Connection getConexion() {
		Connection con = null;
		try {
			//Establecer la ruta del driver conexion --> Nombre del paquete
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Datos para establecer la conexion a la BD
			//			 driver:protocoloDrivers://ubicación&puerto de conexión/BD?datps de la actualización
			String url = "jdbc:mysql://localhost:3306/bd_megamarket?serverTimezone=UTC";
			String usr = "root";//Usuarios
			String psw = "mysql";//Contraseña --> es la que se definió en el proceso de instalación
			
			con = DriverManager.getConnection(url, usr, psw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
