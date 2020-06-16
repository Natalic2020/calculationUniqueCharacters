package ua.com.foxminded.calculation;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Calculation {

	Map<String, String> cacheHashMap = new HashMap<>();
	
	public String calculationUniqueCharacters(final String text) {
		if (text == null) {
			throw new IllegalArgumentException("Null parameters are not allowed");
		}
		if (text.isEmpty()) {
			return "";
		}
		return countUniqueCharacters(text);
	}

	private String countUniqueCharacters(final String text) {
		if (cacheHashMap.get(text)!=null){
			String outputString = cacheHashMap.get(text);
			return String.format("%s%n", text) + outputString;
		}	
		char[] characters = text.toCharArray();
		StringJoiner outputStringJoiner = new StringJoiner("");

		Map<Character, Integer> uniqueCharactersHashMap = new HashMap<>();
		
		for (char symbol : characters) {
			if (uniqueCharactersHashMap.get(symbol) != null) {
				continue;
			}
			long count = text.chars().filter(ch1 -> ch1 == symbol).count();
			outputStringJoiner.add(String.format("\"%s\" - %d%n", symbol, (int) count));
			uniqueCharactersHashMap.put(symbol, (int) count);
		}
		cacheHashMap.put(text, outputStringJoiner.toString());
		return String.format("%s%n", text) + outputStringJoiner.toString();
	}	
}
