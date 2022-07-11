package interfaces;

import java.util.ArrayList;

import entidad.ReporteTipoUsuario;
import entidad.Usuario;

public interface UsuarioInterfacesDAO {

	// registrar
	public int registrar(Usuario u);

	// actualizar
	public int actualizar(Usuario u);

	// eliminar
	public int eliminar(int codigo);

	// listar o consultar tabla
	public ArrayList<Usuario> listarUsuarios();

	// reporte usuario por tipo
	public ArrayList<Usuario> listarUsuarioXtipo(int tipo);

	// reporte usuario por tipo
	public ArrayList<ReporteTipoUsuario> listarReporteUsuarioXTipo(int tipo);

}
