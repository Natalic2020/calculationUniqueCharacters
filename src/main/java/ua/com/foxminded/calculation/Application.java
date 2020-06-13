package ua.com.foxminded.calculation;

public class Application {

	public static void main(String[] args) {
		Calculation calculation = new Calculation();
		String textToCalculationUniqueCharacters = "Hello world!";
		try {
			System.out.println(calculation.calculationUniqueCharacters(textToCalculationUniqueCharacters));
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid  input:\"" + e.getMessage() + "\"");
		}
	}
}
