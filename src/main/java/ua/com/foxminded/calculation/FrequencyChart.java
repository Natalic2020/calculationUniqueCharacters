package ua.com.foxminded.calculation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyChart {

	Map<String, Map<Character, Integer>> cache = new HashMap<>();

	public String formUniqueCharsChartCached(final String text) {
		if (text == null) {
			throw new IllegalArgumentException("Null parameters are not allowed");
		}
		if (text.isEmpty()) {
			return text;
		}
		Map<Character, Integer> uniqueCharacters = countUniqueCharacters(text);
		return formOutputUniqueCharacters(uniqueCharacters, text);
	}

	private Map<Character, Integer>  countUniqueCharacters(final String text) {
		if (cache.containsKey(text)){
			return cache.get(text);
		}	
		Map<Character, Integer> uniqueCharacters = prepareMapWithUniqueCharacters(text);
		cache.merge(text, uniqueCharacters, (oldVal, newVal) -> newVal);
		return uniqueCharacters;
	}

	private String formOutputUniqueCharacters(Map<Character, Integer> uniqueCharacters, final String text) {
		return String.format("%s%n%s", text, uniqueCharacters.entrySet().stream().map(x -> "\"" + x.getKey() + "\" - " + x.getValue().toString())
				.collect(Collectors.joining(System.lineSeparator())));
	}

	private Map<Character, Integer> prepareMapWithUniqueCharacters(final String text) {
		char[] charactersChar = text.toCharArray();
		Map<Character, Integer> uniqueCharacters = new LinkedHashMap<>();	 
		for (char ch : charactersChar) {
			  uniqueCharacters.merge(ch, 1, (oldValue, newValue) -> oldValue + 1);
	        }
		return uniqueCharacters;
	}	
}
