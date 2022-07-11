package utils;

public class Validaciones {

	public static final String CODIGO_PRODUCTO = "[pP]\\d{4}";
	public static final String DNI = "\\d{8}";
	public static final String TEXTO = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]?\\D{3,15}";
	public static final String NOMBRE = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]?\\D{3,15}";
	public static final String APELLIDO = "[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]?\\D{2,25}";
	public static final String USUARIO = "[A-Z]\\d{3}";
	public static final String CLAVE = "\\d{5}";

}
