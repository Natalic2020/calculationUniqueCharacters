package ua.com.foxminded.calculation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculationTest {

	FrequencyChart calculation = new FrequencyChart();

    @Test
    void calculateUniqueCharactersUseCache_shouldThrowIllegalArgumentException_whenInputNull() {
        final String input = null;
        assertThrows(IllegalArgumentException.class, () -> {
        	calculation.calculateUniqueCharactersUseCache(input);
        });
    }

    @Test
    void calculateUniqueCharactersUseCache_shouldReturnEmptyString_whenInputEmptyString() {
        final String input = "";
        final String actual = calculation.calculateUniqueCharactersUseCache(input);
        final String expected = input;

        assertEquals(expected, actual);
    }

    @Test
    void calculateUniqueCharactersUseCache_shouldCountSymbol_whenInputText() {
    	final String input = "Hello world!";
        final String actual = calculation.calculateUniqueCharactersUseCache(input);
        final String expected = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s", //
			"Hello world!", // 
			"\"H\" - 1",  // 
			"\"e\" - 1",  // 
			"\"l\" - 3",  // 
			"\"o\" - 2",  // 
			"\" \" - 1",  // 
			"\"w\" - 1",  // 
			"\"r\" - 1",  // 
			"\"d\" - 1",  // 
			"\"!\" - 1");
    assertEquals(expected, actual);
    }
    
    @Test
    void calculateUniqueCharactersUseCache_shouldReturnCountBigAndSmallLettersApart_whenInputTextWithTheSameBigAndSmallLetters() {
    	final String input = "HhHh HuH!";
        final String actual = calculation.calculateUniqueCharactersUseCache(input);
        final String expected = String.format("%s%n%s%n%s%n%s%n%s%n%s", //
			"HhHh HuH!",  // 
			"\"H\" - 4",  // 
			"\"h\" - 2",  // 
			"\" \" - 1",  // 
			"\"u\" - 1",  // 
			"\"!\" - 1");
    assertEquals(expected, actual);
    }
}
