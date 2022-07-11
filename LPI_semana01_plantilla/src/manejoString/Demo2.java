package manejoString;

public class Demo2 {

	public static void main(String[] args) {

		String user = "Nando";
		String user1 = "Nando";

		// comparación de dirección de memoria
		if (user == user1)
			System.out.println("igual dirección de memoria");
		else
			System.out.println("Diferente dirección de memoria");

		// comparación de texto

		if (user.equals(user1))
			System.out.println("igual contenido");
		else
			System.out.println("Diferente contenido");

	}

}
