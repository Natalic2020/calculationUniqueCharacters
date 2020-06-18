package ua.com.foxminded.calculation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Character[] characters = new String(charactersChar).chars()
			    .mapToObj(i -> (char) i).toArray(Character[]::new);
		
		Map<Character, Integer> uniqueCharacters = new HashMap<>();
		
		Stream.of(characters).forEach(character -> uniqueCharacters.merge(character, 1, (prev,one) -> prev + one));
		
		String outputUniqueCharacters = uniqueCharacters.entrySet().stream().map(x -> "\"" + x.getKey() + "\" - " + x.getValue().toString())
				.collect(Collectors.joining("\n"));
	
		cache.merge(text, outputUniqueCharacters.toString(), (oldVal, newVal) -> newVal);

		return String.format("%s%n", text) + outputUniqueCharacters;
	}	
}
