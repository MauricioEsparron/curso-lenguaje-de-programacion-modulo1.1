package entidad;

public class Empleado {

	private int codigo;
	private String nombre;
	private String apellido;
	private int dni;
	private int numHijos;
	private double sueldo;
	private int codDistrito;

	public Empleado() {

	}

	public Empleado(int codigo, String nombre, String apellido, int dni, int numHijos, double sueldo, int codDistrito) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.numHijos = numHijos;
		this.sueldo = sueldo;
		this.codDistrito = codDistrito;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getNumHijos() {
		return numHijos;
	}

	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getCodDistrito() {
		return codDistrito;
	}

	public void setCodDistrito(int codDistrito) {
		this.codDistrito = codDistrito;
	}

}
