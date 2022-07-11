package manejoString;

public class Demo1 {

	public static void main(String[] args) {

		String texto = "Programar es lo m�ximo";

		// m�todos principales de la clase

		// Requerimientos
		// cantidad de caracteres
		System.out.println("Cantidad de caracteres : " + texto.length());
		System.out.println("Cantidad de la posici�n 5 : " + texto.charAt(5));
		System.out.println("El texto inicia con la letra A : " + texto.startsWith("A"));
		System.out.println("El texto termina con la letra o : " + texto.endsWith("o"));
		System.out.println("El texto en may�sculas : " + texto.toUpperCase());
		System.out.println("El texto en min�sculas : " + texto.toLowerCase());
		System.out.println("Reemplaza la a -> e : " + texto.replace("a", "e"));
		System.out.println("El texto sin espacios : " + texto.trim());

		// obtener cda palabra del texto

		//m�todo 1
		System.out.println("Palabras : " + texto.substring(0, texto.length()));

		//m�todo 2
		for (int i = 0; i < texto.length(); i++) {
			if (i < texto.length()) {
				System.out.println(texto.charAt(i));
			}
		}

		//m�todo 3
		String palabra[] = texto.split(" ");
		for (String palab : palabra) {

			System.out.println(palab);
		}

	}

}
