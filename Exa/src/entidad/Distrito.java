package entidad;

public class Distrito {

	private int codDistrito;
	private String nombreDistrito;

	public Distrito() {

	}

	public Distrito(int codDistrito, String nombreDistrito) {
		this.codDistrito = codDistrito;
		this.nombreDistrito = nombreDistrito;
	}

	public int getCodDistrito() {
		return codDistrito;
	}

	public void setCodDistrito(int codDistrito) {
		this.codDistrito = codDistrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

}
