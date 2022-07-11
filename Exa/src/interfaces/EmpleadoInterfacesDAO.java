package interfaces;

import java.util.ArrayList;

import entidad.Empleado;

public interface EmpleadoInterfacesDAO {

	public int registrar(Empleado e);

	public int actualizar(Empleado c);

	public int eliminar(int codigoEmpleado);

	public ArrayList<Empleado> listarEmpleado();

}
