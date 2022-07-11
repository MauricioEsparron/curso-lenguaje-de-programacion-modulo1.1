package tretamientoExcepcionesTryCatch;

public class Demo2 {

	public static void main(String[] args) {

		// Exception de formato de número
		int num1, num2, res;
		try {
			num1 = 60;
			num2 = 90;
			num2 = num2 - (num1 + 30);
			res = num1 / num2;
			System.out.println("resultado : " + res);
		} catch (ArithmeticException e) {
			System.out.println("no se puede dividir entre 0");
			System.out.println("Error : " + e.getMessage());
//			e.printStackTrace();

		}
	}

}
