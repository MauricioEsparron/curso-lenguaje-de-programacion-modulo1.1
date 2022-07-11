package tretamientoExcepcionesTryCatch;

public class Demo1 {

	public static void main(String[] args) {

		// Exception de formato de n�mero
		int suma;
		try {
			int num1 = Integer.parseInt("10");
			int num2 = Integer.parseInt("doce");
			suma = num1 + num2;
			System.out.println("Resultado : " + suma);
		} catch (NumberFormatException e) {
			System.out.println("Error en el formato de n�mero");
			System.out.println("Error : " + e.getMessage());
//			e.printStackTrace();
		}

	}

}
