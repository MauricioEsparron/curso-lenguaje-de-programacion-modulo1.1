package tretamientoExcepcionesTryCatch;

public class Demo3 {

	public static void main(String[] args) {

		// Exception fuera del tamaño del Arreglo
		try {
			String nombres[] = { "Guerrero", "Advincula", "Flores", "Lapadula" };
			for (int i = 0; i < 7; i++) {
				System.out.println("Nombres : " + nombres[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error incice fuera de rango : " + e.getMessage());
		}

	}

}
