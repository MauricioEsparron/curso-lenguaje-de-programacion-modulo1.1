package manejoString;

public class ComparandoCadenas {

	public static void main(String[] args) {

		// Clase String

		long REPETICIONES = 60000; // veces a evaluar
		String s = "";
		long tiempo = System.currentTimeMillis(); // tiempo inicial
		for (int i = 0; i < REPETICIONES; i++) {
			s += "a";
		}
		tiempo = System.currentTimeMillis() - tiempo;
		System.out.println("String ha tardado: " + tiempo + " milisegundos");

		// Clase StringBuffer
		StringBuffer s2 = new StringBuffer();
		tiempo = System.currentTimeMillis();
		for (int i = 0; i < REPETICIONES; i++) {
			s2.append("a");
		}
		tiempo = System.currentTimeMillis() - tiempo;
		System.out.println("StringBuffer ha tardado: " + tiempo + " milisegundos");

		// Clase StringBuilder
		StringBuilder s3 = new StringBuilder();
		tiempo = System.currentTimeMillis();
		for (int i = 0; i < REPETICIONES; i++) {
			s2.append("a");
		}
		tiempo = System.currentTimeMillis() - tiempo;
		System.out.println("StringBuilder ha tardado: " + tiempo + " milisegundos");
	}

}
