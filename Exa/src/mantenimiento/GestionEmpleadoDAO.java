package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import entidad.Empleado;
import interfaces.EmpleadoInterfacesDAO;
import utils.MySQLConexion8;

public class GestionEmpleadoDAO implements EmpleadoInterfacesDAO {

	@Override
	public int registrar(Empleado e) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "insert into tb_empleado values (null,?,?,?,?,?,?)";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getApellido());
			pstm.setInt(3, e.getDni());
			pstm.setInt(4, e.getNumHijos());
			pstm.setDouble(5, e.getSueldo());
			pstm.setInt(6, e.getCodDistrito());

			res = pstm.executeUpdate();

		} catch (Exception a) {
			System.out.println(">>>>>>Error en la instruccion SQL - Registrar " + a.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int actualizar(Empleado e) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_empleado set nombre = ?,apellido = ?, dni = ?, telefono = ? where codtb_cliente = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, e.getNombre());
			pstm.setString(2, e.getApellido());
			pstm.setInt(3, e.getDni());
			pstm.setInt(4, e.getNumHijos());
			pstm.setDouble(5, e.getSueldo());
			pstm.setInt(6, e.getCodDistrito());
			pstm.setInt(7, e.getCodigo());

			res = pstm.executeUpdate();

		} catch (Exception a) {
			System.out.println(">>>>>>Error en la instruccion SQL - Actualizar " + a.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public int eliminar(int codigoEmpleado) {
		return 0;
	}

	@Override
	public ArrayList<Empleado> listarEmpleado() {
		return null;
	}

}
