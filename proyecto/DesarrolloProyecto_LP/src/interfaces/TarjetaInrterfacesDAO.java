package interfaces;

import java.util.ArrayList;

import entidad.Cliente;
import entidad.Tarjeta;

public interface TarjetaInrterfacesDAO {

	public int registrar(Tarjeta t);

	public int actualizar(Tarjeta t);

	public int eliminar(int num_Tarjeta);

	public ArrayList<Tarjeta> listartarjeta();
	
	public ArrayList<Tarjeta> listarTarjetaXTipoCuenta(int tipoCuenta);
	
	public ArrayList<Tarjeta> listarClienteXCodigoCliente(int codCliente);


//	public ArrayList<Tarjeta> listarComboBox();
}
