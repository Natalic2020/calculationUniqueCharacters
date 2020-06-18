package ua.com.foxminded.calculation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyChart {

	Map<String, String> cache = new HashMap<>();
	
	public String calculationUniqueCharacters(final String text) {
		return calculateUniqueCharactersUseCache(text);
	}

	public String calculateUniqueCharactersUseCache(final String text) {
		if (text == null) {
			throw new IllegalArgumentException("Null parameters are not allowed");
		}
		if (text.isEmpty()) {
			return text;
		}
		return countUniqueCharacters(text);
	}

	private String countUniqueCharacters(final String text) {
		if (cache.containsKey(text)){
			String outputString = cache.get(text);
			return String.format("%s%n", text) + outputString;
		}	
		char[] charactersChar = text.toCharArray();
		
		Map<Character, Integer> uniqueCharacters = new LinkedHashMap<>();
		 
		for (char ch : charactersChar) {
			  uniqueCharacters.merge(ch, 1, (oldValue, newValue) -> oldValue + 1);
	        }
		String outputUniqueCharacters = uniqueCharacters.entrySet().stream().map(x -> "\"" + x.getKey() + "\" - " + x.getValue().toString())
				.collect(Collectors.joining(System.lineSeparator()));
	
		cache.merge(text, outputUniqueCharacters, (oldVal, newVal) -> newVal);

		return String.format("%s%n", text) + outputUniqueCharacters;
	}	
}
