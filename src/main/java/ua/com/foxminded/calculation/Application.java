package ua.com.foxminded.calculation;

public class Application {

	public static void main(String[] args) {
		FrequencyChart calculation = new FrequencyChart();
		String[] textToCalculationUniqueCharacters = new String[] { "Hello world!", "Goo01d eve//ning",
				"Hello world!" };
		for (String input : textToCalculationUniqueCharacters) {
			try {
				System.out.println(calculation.formUniqueCharsChartCached(input));
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid  input:\"" + e.getMessage() + "\"");
			}
		}
	}
}
