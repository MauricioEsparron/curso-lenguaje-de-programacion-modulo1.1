package manejoString;

public class Demo2 {

	public static void main(String[] args) {

		String user = "Nando";
		String user1 = "Nando";

		// comparaci�n de direcci�n de memoria
		if (user == user1)
			System.out.println("igual direcci�n de memoria");
		else
			System.out.println("Diferente direcci�n de memoria");

		// comparaci�n de texto

		if (user.equals(user1))
			System.out.println("igual contenido");
		else
			System.out.println("Diferente contenido");

	}

}
