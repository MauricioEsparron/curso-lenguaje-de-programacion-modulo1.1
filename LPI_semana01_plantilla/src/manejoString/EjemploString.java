package manejoString;

import java.util.Iterator;

public class EjemploString {

	public static void main(String[] args) {

		String texto = "a001;  Juancito ;  Pando  ;12;05;LP1";

		// Separar los textos en código, nombre, apellido, nota1, nota2 y curso

		String separar[] = texto.split(";");

		// asignar valores a una variable
		String cod = separar[0];
		String nomb = separar[1].trim().toLowerCase();
		String ape = separar[2].trim();
		int n1 = Integer.parseInt(separar[3]);
		int n2 = Integer.parseInt(separar[4]);
		String curso = separar[5];

		// mostrar los datos
		for (String p : separar) {
			System.out.println(p.trim());
		}

		// Convertir el apellido a mayúscula y el nombre el minúscula

		System.out.println("Apellido a mayusculas : " + ape.toUpperCase());

		// Validar que el código empiece con la letras “a” o “p”
		System.out.println(
				"Cod empieza por a : " + cod.startsWith("a") + " || Cod empieza por p : " + cod.startsWith("p"));

		// validar que el tamaño del código sea 4

		if (cod.length() == 4) {
			System.out.println("el tamaño del cod es de 4 : si");
		} else {

			System.out.println("el tamaño del cod es de 4 : no");
		}

		// Generar un correo con el siguiente formato: 1° letra del nombre + parte
		// numérica del código + @cibertec.pe. Ej. j001@cibertec.edu.pe
		// cod = "a001";
		// pos -> 0123

//		String letra[] = cod.split("a");
//		for (String l : letra) {
//
//			System.out.println(nomb + l + "@cibertec.pe");
//		}

		char primerComponente = nomb.charAt(0);
		String segundoComponente = cod.substring(1);
		System.out.println(primerComponente + segundoComponente + "@cibertec.edu.pe");

		// Mostrar los datos

	}

}
