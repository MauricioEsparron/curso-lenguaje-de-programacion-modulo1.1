package interfaces;

import java.util.ArrayList;

import entidad.TipoOperacion;

public interface TipoOperacionInterfacesDAO {

	public int registrar(TipoOperacion to);

	public int actualizar(TipoOperacion to);

	public int eliminar(int codOperacion);

	public ArrayList<TipoOperacion> listaTipoOperacion();
}
