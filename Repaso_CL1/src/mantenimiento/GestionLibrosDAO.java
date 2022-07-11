package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidad.Libros;
import interfaces.LibroInterfacesDAO;
import utils.MySQLConexion8;

public class GestionLibrosDAO implements LibroInterfacesDAO {

	@Override
	public int registrarLibro(Libros lib) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {

			// 1. conectar a la BD

			con = MySQLConexion8.getConexion();

			// 2. definir la instruccion SQL --> REGISTRAR
			String sql = "insert into tb_libros values (null,?,?,?,?)";

			// 3.crear el objeto pstm y prepararla instrucción SQL

			pstm = con.prepareStatement(sql);

			// 4. parametros

			pstm.setString(1, lib.getNombre());
			pstm.setString(2, lib.getAutor());
			pstm.setInt(3, lib.getStock());
			pstm.setDouble(4, lib.getPrecio());

			// 5. ejecutar la instruccion SQL

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la instrucción SQL - Registrar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();

				if (pstm != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la BD");
			}
		}

		return 0;
	}

}
