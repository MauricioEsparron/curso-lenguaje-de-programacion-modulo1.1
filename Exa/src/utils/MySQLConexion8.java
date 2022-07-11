package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	//metodo encargado de realizar la conexi�n con la BD
	public static Connection getConexion() {
		//declrando un objeto de tipo "Connection"
		Connection con = null;
		try {
			//estableciendo la ruta del driver de conexi�n  -> nombre del paquete
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Datos de conexi�n
			//driver:protocoloDriver/ubicaci�n/nombreBD/actualizaci�n
			String url = "jdbc:mysql://localhost:3306/bd_ventas?serverTimezone=UTC";
			String usr = "root";//root
			String psw = "123456";//contrase�a
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
