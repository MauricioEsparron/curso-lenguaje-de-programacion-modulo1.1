package entidad;

public class ReporteTipoUsuario {

	// atributos privados
	private int codigo;
	private String nombresCompletos;
	private String descTipo;

	public ReporteTipoUsuario() {

		// constructores
		super();
	}

	public ReporteTipoUsuario(int codigo, String nombresCompletos, String desctipo) {
		super();
		this.codigo = codigo;
		this.nombresCompletos = nombresCompletos;
		this.descTipo = desctipo;
	}

	// metodos de acceso
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombresCompletos() {
		return nombresCompletos;
	}

	public void setNombresCompletos(String nombresCompletos) {
		this.nombresCompletos = nombresCompletos;
	}

	public String getDescTipo() {
		return descTipo;
	}

	public void setDescTipo(String desctipo) {
		this.descTipo = desctipo;
	}

}
