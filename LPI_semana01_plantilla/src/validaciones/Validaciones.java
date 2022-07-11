package validaciones;

public class Validaciones {

	public static final String CODIGO_PRODUCTO = "[Pp]\\d{4}";

	public static final String CODIGO_CLIENTES = "[CL]\\d{3}";

	public static final String DNI = "\\d{8}";

	public static final String TEXTO = "[a-zA-ZáéíóúÁÉÍÓÚ\\s]{3,15}"; // < - ambos funcionan igual -> public static
																		// final String TEXTO = "\\D{3,15}";

	public static final String CORREO = "[a-zA-Z]{2,5}\\W+hotmail\\W+com"; // "\\D{5,20}//@//D{5,20}";

	public static final String NOMBRE = "[a-zA-ZZáéíóúÁÉÍÓÚ\\s]{3,30}";

	public static final String APELLIDO = "[a-zA-ZZáéíóúÁÉÍÓÚ\\s]{3,30}";

	public static final String TELEFONO = "\\d{9}";

}
