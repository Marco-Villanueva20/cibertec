package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	public static Connection getConexion() {
		//Declarando un objeto del tipo conection
		Connection con = null;
		try {
			//Establecer la ruta del driver de conection(com.mysql.jdbc
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Datos para la conexion a la bd
			// 			Driver: protocoloDriver/ubicacion/nombreBD/datos de actualizacion
			String url = "jdbc:mysql://localhost:3306/ciberfarma?serverTimezone=UTC";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexi�n con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
