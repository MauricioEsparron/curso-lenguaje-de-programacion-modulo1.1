package entidad;

public class Libros {

	// atributos privados
	private int codigo;
	private String nombre;
	private String autor;
	private int stock;
	private double precio;

	// constructor
	public Libros() {

	}

	public Libros(int codigo, String nombre, String autor, int stock, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.autor = autor;
		this.stock = stock;
		this.precio = precio;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
