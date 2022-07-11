package interfaces;

import java.util.ArrayList;

import entidad.TipoCuenta;

public interface TipoCuentaInterfacesDAO {

	public int registrar(TipoCuenta tc);

	public int actualizar(TipoCuenta tc);

	public int eliminar(int codTipoCuenta);

	public ArrayList<TipoCuenta> listaTipoCuenta();

}
