package tretamientoExcepcionesTryCatch;

import javax.swing.JButton;

public class Demo4 {

	public static void main(String[] args) {

		// Exception fuera del tamaño del Arreglo

		String texto = "a";
		try {
			JButton btn = null;
			texto += "b";
			btn.setText("Procesar");
			texto += "cd";
			System.out.println("Resultado : " + texto);
		} catch (NullPointerException e) {
			texto += "z";
			e.printStackTrace();
		}
		System.out.println("Holaaaa");
	}

}
