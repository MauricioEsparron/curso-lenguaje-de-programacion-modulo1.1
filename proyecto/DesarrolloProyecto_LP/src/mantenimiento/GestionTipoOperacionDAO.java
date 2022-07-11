package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.TipoOperacion;
import interfaces.TipoOperacionInterfacesDAO;
import utils.MySQLConexion8;

public class GestionTipoOperacionDAO implements TipoOperacionInterfacesDAO {

	@Override
	public int registrar(TipoOperacion to) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "insert into bd_banca.tb_operacion values (null,?)";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, to.getDescripcion());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Registrar " + e.getMessage());
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
	public int actualizar(TipoOperacion to) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "update tb_operacion set descripcion = ? where codtb_operacion = ?;";

			pstm = con.prepareStatement(sql);

			pstm.setString(1, to.getDescripcion());
			pstm.setInt(2, to.getCod_operacion());

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Actualizar " + e.getMessage());
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
	public int eliminar(int codOperacion) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();

			String sql = "delete from tb_operacion where codtb_operacion = ?";

			pstm = con.prepareStatement(sql);

			pstm.setInt(1, codOperacion);

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Eliminar " + e.getMessage());
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
	public ArrayList<TipoOperacion> listaTipoOperacion() {
		ArrayList<TipoOperacion> lista = new ArrayList<TipoOperacion>();
		TipoOperacion tipo;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		try {

			con = MySQLConexion8.getConexion();
			String sql = "SELECT *FROM tb_operacion";

			pstm = con.prepareStatement(sql);

			res = pstm.executeQuery();

			while (res.next()) {

				tipo = new TipoOperacion();

				tipo.setCod_operacion(res.getInt(1));
				tipo.setDescripcion(res.getString(2));

				lista.add(tipo);

			}

		} catch (Exception e) {
			System.out.println(">>>>>>Error en la instruccion SQL - Consultar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (pstm != null)
					con.close();
				if (pstm != null)
					res.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return lista;
	}

}
