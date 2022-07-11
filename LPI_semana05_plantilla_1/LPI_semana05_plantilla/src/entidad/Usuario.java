package entidad;

public class Usuario {
	// atributos
	private int codigo;
	private String nombre;
	private String apellido;
	private String usuario;
	private String Clave;
	private String FNacim;
	private int tipo;
	private int estado;

	// contructores
	public Usuario(int codigo, String nombre, String apellido, String usuario, String clave, String fNacim, int tipo,
			int estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		Clave = clave;
		FNacim = fNacim;
		this.tipo = tipo;
		this.estado = estado;
	}

	// metodos de acceso get/set

	public Usuario() {
		// TODO Auto-generated constructor stub
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public String getFNacim() {
		return FNacim;
	}

	public void setFNacim(String fNacim) {
		FNacim = fNacim;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
