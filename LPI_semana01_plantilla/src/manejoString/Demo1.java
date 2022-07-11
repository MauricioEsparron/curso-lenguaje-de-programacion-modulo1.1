package manejoString;

public class Demo1 {

	public static void main(String[] args) {

		String texto = "Programar es lo máximo";

		// métodos principales de la clase

		// Requerimientos
		// cantidad de caracteres
		System.out.println("Cantidad de caracteres : " + texto.length());
		System.out.println("Cantidad de la posición 5 : " + texto.charAt(5));
		System.out.println("El texto inicia con la letra A : " + texto.startsWith("A"));
		System.out.println("El texto termina con la letra o : " + texto.endsWith("o"));
		System.out.println("El texto en mayúsculas : " + texto.toUpperCase());
		System.out.println("El texto en minúsculas : " + texto.toLowerCase());
		System.out.println("Reemplaza la a -> e : " + texto.replace("a", "e"));
		System.out.println("El texto sin espacios : " + texto.trim());

		// obtener cda palabra del texto

		//método 1
		System.out.println("Palabras : " + texto.substring(0, texto.length()));

		//método 2
		for (int i = 0; i < texto.length(); i++) {
			if (i < texto.length()) {
				System.out.println(texto.charAt(i));
			}
		}

		//método 3
		String palabra[] = texto.split(" ");
		for (String palab : palabra) {

			System.out.println(palab);
		}

	}

}
