package tretamientoExcepcionesTryCatch;

import javax.swing.JButton;

public class Demo6 {

	public static void main(String[] args) {

		String x = "a";//a
		try {
			x += "b";//ab
			String cadena = "JAVA";
			cadena.charAt(9); //Error!!
			x += "c";
			double[] y = new double[11];
			y[15] = 3.1;
			x += "d";
		} catch (ArrayIndexOutOfBoundsException e) {
			x += "e";
		} catch (StringIndexOutOfBoundsException e) {
			x += "f";//abfg
		} finally {
			x += "g";//abfg
		}
		System.out.println("x = " + x);//x = abeg
	}

}
