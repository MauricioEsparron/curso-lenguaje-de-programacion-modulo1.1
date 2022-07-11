package manejoString;

public class EjemploEncriptado {

	public static void main(String[] args) {

		String texto = "Hola mundo esto es un texto";
		StringBuilder encriptado = new StringBuilder();

		encriptado.append(texto);
		encriptado.reverse();

		for (int i = 0; i < texto.length(); i++) {
			switch (encriptado.charAt(i)) {
			case 'a':
				encriptado.setCharAt(i, 'e');
				break;
			case 'e':
				encriptado.setCharAt(i, 'i');
				break;
			case 'i':
				encriptado.setCharAt(i, 'o');
				break;
			case 'o':
				encriptado.setCharAt(i, 'u');
				break;
			case 'u':
				encriptado.setCharAt(i, 'a');
				break;

			}
		}
		// salida
		System.out.println(">>>>>>>>>>>>>>>> CiberEncriptado <<<<<<<<<");
		System.out.println("texto original : " + texto);
		System.out.println("texto encriptado : " + encriptado);

		StringBuilder desencriptado = new StringBuilder();
		desencriptado.append(encriptado);
		desencriptado.reverse();

		for (int i = 0; i < texto.length(); i++) {
			switch (desencriptado.charAt(i)) {
			case 'e':
				desencriptado.setCharAt(i, 'a');
				break;
			case 'i':
				desencriptado.setCharAt(i, 'e');
				break;
			case 'o':
				desencriptado.setCharAt(i, 'i');
				break;
			case 'u':
				desencriptado.setCharAt(i, 'o');
				break;
			case 'a':
				desencriptado.setCharAt(i, 'u');
				break;


			}
		}
		// salida
		System.out.println(">>>>>>>>>>>>>>>> CiberDesEncriptado <<<<<<<<<");
		System.out.println("texto original : " + encriptado);
		System.out.println("texto encriptado : " + desencriptado);

	}

}
