package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.ReporteTipoUsuario;
import entidad.Usuario;
import interfaces.UsuarioInterfacesDAO;
import utils.MySQLConexion8;

public class GestionUsuarioDAO implements UsuarioInterfacesDAO {

	public int registrar(Usuario u) {
		// Declaraci�n de variables
		int res = 0;
		Connection con = null;
		// permite ejecutar comandos sql
		PreparedStatement pstm = null;
		try {

			// paso 1: Establecer la conexi�n a la BD
			con = MySQLConexion8.getConexion();

			// paso 2: determinar la instrucci�n SQL --> Registrar
			// insert into tb_usuarios values
			// (null,'Sandra','Perez','U005','12345','2022-10-21',default,default);
			String sql = "insert into tb_usuarios values (null,?,?,?,?,?,default,default)";

			// paso 3: crear el objeto pstm y enviar la variable SQL
			pstm = con.prepareStatement(sql);

			// paso 4: parametros
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setString(5, u.getFNacim());

			// paso 5: ejecutar la instrucci�n
			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>> Error en la intrucci�n SQL - Registrar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					pstm.close();

			} catch (SQLException e2) {

				System.out.println("<<<<<<<<< Error al cerrar la base de datos " + e2.getMessage());

			}
		}

		return res;
	}

	public int actualizar(Usuario u) {

		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			// paso 1: Establecer la conexi�n a la BD

			con = MySQLConexion8.getConexion();

			// paso 2: determinar la instrucci�n SQL --> Actualizar

			// update tb_usuarios set nombre ='Javier',apellido = 'Escalera',usuario =
			// 'U018', clave = '23456', fnacim = '2022-05-03' where codigo = 15;

			// 'set lastname = 'Fernandez', username = 'U003',password = '12345',fnacim =
			// '2022-05-0'

			String sql = "update tb_usuarios set nombre = ?,set apellido = ?, usuario = ?,clave = ?,fnacim = ? where codigo = ?";

			// paso 3: crear el objeto pstm y enviar la variable SQL

			pstm = con.prepareStatement(sql);

			// paso 4: parametros

			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setString(5, u.getFNacim());
			pstm.setInt(6, u.getCodigo());

			// paso 5: ejecutar la instrucci�n

			res = pstm.executeUpdate();
			System.out.println("ok");

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>> Error en la intrucci�n SQL - Registrar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					pstm.close();

			} catch (Exception e2) {

				System.out.println(">>>>>>>>>>>>>> Error al cerrar la base de datos " + e2.getMessage());

			}
		}

		return res;
	}

	public int eliminar(int codigo) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			// paso 1: Establecer la conexi�n a la BD

			con = MySQLConexion8.getConexion();

			// paso 2: determinar la instrucci�n SQL --> Actualizar

			// update tb_usuarios set nombre ='Javier',apellido = 'Escalera',usuario =
			// 'U018', clave = '23456', fnacim = '2022-05-03' where codigo = 15;

			// 'set lastname = 'Fernandez', username = 'U003',password = '12345',fnacim =
			// '2022-05-0'

			String sql = "delete from tb_usuarios where codigo = ?";

			// paso 3: envair instrucci�n al objeto pstm --> obtener comando SQL

			pstm = con.prepareStatement(sql);

			// paso 4: parametros

			pstm.setInt(1, codigo);

			// paso 5: ejecutar la instrucci�n

			res = pstm.executeUpdate();

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>> Error en la intrucci�n SQL - Registrar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					pstm.close();

			} catch (Exception e2) {

				System.out.println(">>>>>>>>>>>>>> Error al cerrar la base de datos " + e2.getMessage());

			}
		}

		return res;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();// null
		Usuario user;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {

			// paso 1: Establecer la conexi�n a la BD

			con = MySQLConexion8.getConexion();

			// paso 2: determinar la instrucci�n SQL --> Consultar

			String sql = "select * from ciberfarma.tb_usuarios;";
			// paso 3: enviar la instrucci�n al objeto pstm --> comandos SQL
			pstm = con.prepareStatement(sql);
			// paso 4: parametros -- NO HAY
			// paso 5: ejecutar la instrucci�n
			res = pstm.executeQuery();
			// paso 6: bucle para realizar el recorrido al objeto "res"
			while (res.next()) {
				// crear un objeto de tipo "Usuario"
				user = new Usuario();
				// setear (asignar valores del objeto "res" a los atributos privados)
				user.setCodigo(res.getInt(1));
				user.setNombre(res.getString(2));
				user.setApellido(res.getString(3));
				user.setUsuario(res.getString(4));
				user.setClave(res.getString(5));
				user.setFNacim(res.getString(6));
				user.setTipo(res.getInt(7));
				user.setEstado(res.getInt(8));

				// a�adir el objeto "user" al arreglo

				lista.add(user);

			}

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>>>>>>> Error en la intrucci�n SQL - Registrar " + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					pstm.close();

			} catch (Exception e2) {

				System.out.println(">>>>>>>>>>>>>> Error al cerrar la base de datos " + e2.getMessage());

			}
		}

		return lista;
	}

	public ArrayList<ReporteTipoUsuario> listarReporteUsuario(int tipo) {
		ArrayList<ReporteTipoUsuario> lista = new ArrayList<ReporteTipoUsuario>();// null
		ReporteTipoUsuario repUser;
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet res = null;
		try {
			// paso 1: Establecer la conexi�n a la base de datos
			con = MySQLConexion8.getConexion();

			// Paso 2 : determinar la instrucci�n SQL --> Consultar
			String sql = "{call usp_listarUsuario(?)}";

			// paso 3: enviar la instrucci�n al objeto pstm -- comandos SQL
			pstm = con.prepareStatement(sql);

			// paso 4 : parametros --
			pstm.setInt(1, tipo);

			// paso 5 : ejecutar la instrucci�n
			res = pstm.executeQuery();

			// paso 6 : bucle para realizar el recorrido al objeto "res"
			while (res.next()) {

				// crear un objeto de tipo "Usuario"
				repUser = new ReporteTipoUsuario();
				// setear (asignar valores del objeto "res" a los atributos privados)
				repUser.setCodigo(res.getInt(1));
				repUser.setNombresCompletos(res.getString(2));
				repUser.setDescTipo(res.getString(3));

				// a�adir el objeto "user" al arreglo
				lista.add(repUser);
			}

		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>> Error en la Instrucci�n SQL - Consultar" + e.getMessage());
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (res != null)
					res.close();
				if (con != null)
					con.close();

			} catch (SQLException e2) {
				System.out.println("<<<< Error al cerrar la base de datos " + e2.getMessage());
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Usuario> listarUsuarioXtipo(int tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReporteTipoUsuario> listarReporteUsuarioXTipo(int tipo) {
		// TODO Auto-generated method stub
		return null;
	}
}
