package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	//metodo encargado de realizar la conexión con la BD
	public static Connection getConexion() {
		//declrando un objeto de tipo "Connection"
		Connection con = null;
		try {
			//estableciendo la ruta del driver de conexión  -> nombre del paquete
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Datos de conexión
			//driver:protocoloDriver/ubicación/nombreBD/actualización
			String url = "jdbc:mysql://localhost:3306/ciberfarma?serverTimezone=UTC";
			String usr = "root";//root
			String psw = "123456";//contraseña
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
