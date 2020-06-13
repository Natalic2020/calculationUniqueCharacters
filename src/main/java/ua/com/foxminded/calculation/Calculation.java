package ua.com.foxminded.calculation;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Calculation {

	public String calculationUniqueCharacters(final String text) {

		if (text == null) {
			throw new IllegalArgumentException("Null parameters are not allowed");
		}
		if (text.isEmpty()) {
			return "";
		}
		char[] characters = text.toCharArray();
		StringJoiner outputStringJoiner = new StringJoiner("");

		Map<Character, Integer> uniqueCharactersHashMap = new HashMap<>();
		Map<String, String> cacheHashMap = new HashMap<>();

		for (char symbol : characters) {
			if (uniqueCharactersHashMap.get(symbol) != null) {
				continue;
			}
			long count = text.chars().filter(ch -> ch == symbol).count();
			outputStringJoiner.add(String.format("\"%s\" - %d%n", symbol, (int) count));
			uniqueCharactersHashMap.put(symbol, (int) count);
		}
		cacheHashMap.put(text, outputStringJoiner.toString());
		return String.format("%s%n", text) + outputStringJoiner.toString();
	}
}
