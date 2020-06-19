package ua.com.foxminded.calculation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculationTest {

	FrequencyChart calculation = new FrequencyChart();

    @Test
    void formUniqueCharsChartCached_shouldThrowIllegalArgumentException_whenInputNull() {
        final String input = null;
        assertThrows(IllegalArgumentException.class, () -> {
        	calculation.formUniqueCharsChartCached(input);
        });
    }

    @Test
    void formUniqueCharsChartCached_shouldReturnEmptyString_whenInputEmptyString() {
        final String input = "";
        final String actual = calculation.formUniqueCharsChartCached(input);
        final String expected = input;

        assertEquals(expected, actual);
    }
    
    @Test
    void formUniqueCharsChartCached_shouldCountDigits_whenInputDigits() {
    	final String input = "12345612333";
        final String actual = calculation.formUniqueCharsChartCached(input);
        final String expected = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s", //
			"12345612333",  //
			"\"1\" - 2",  //
			"\"2\" - 2",  //
			"\"3\" - 4",  //
			"\"4\" - 1",  //
			"\"5\" - 1",  //
			"\"6\" - 1");
    assertEquals(expected, actual);
    }

    @Test
    void formUniqueCharsChartCached_shouldCountDigits_whenInputOnlyDigits() {
    	final String input = "12345612333";
        final String actual = calculation.formUniqueCharsChartCached(input);
        final String expected = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s", //
			"12345612333",  //
			"\"1\" - 2",  //
			"\"2\" - 2",  //
			"\"3\" - 4",  //
			"\"4\" - 1",  //
			"\"5\" - 1",  //
			"\"6\" - 1");
    assertEquals(expected, actual);
    }
    
    @Test
    void formUniqueCharsChartCached_shouldCountSpecialCharacters_whenInputOnlySpecialCharacters() {
    	final String input = "!@*/&%$§!@!@";
        final String actual = calculation.formUniqueCharsChartCached(input);
        final String expected = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s", //
			"!@*/&%$§!@!@",  // 
			"\"!\" - 3",  // 
			"\"@\" - 3",  // 
			"\"*\" - 1",  // 
			"\"/\" - 1",  // 
			"\"&\" - 1",  // 
			"\"%\" - 1",  // 
			"\"$\" - 1",  // 
			"\"§\" - 1");
    assertEquals(expected, actual);
    }
    
    @Test
    void formUniqueCharsChartCached_shouldCountSymbols_whenInputText() {
    	final String input = "Hello world!";
        final String actual = calculation.formUniqueCharsChartCached(input);
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
    void formUniqueCharsChartCached_shouldReturnCountBigAndSmallLettersApart_whenInputTextWithTheSameBigAndSmallLetters() {
    	final String input = "HhHh HuH!";
        final String actual = calculation.formUniqueCharsChartCached(input);
        final String expected = String.format("%s%n%s%n%s%n%s%n%s%n%s", //
			"HhHh HuH!",  // 
			"\"H\" - 4",  // 
			"\"h\" - 2",  // 
			"\" \" - 1",  // 
			"\"u\" - 1",  // 
			"\"!\" - 1");
    assertEquals(expected, actual);
    }
    
    @Test
    void formUniqueCharsChartCached_shouldCountSymbols_whenInputLettersDigitsSpecialCharacters() {
    	final String input = "Hehe&%$125Bebe55%%";
        final String actual = calculation.formUniqueCharsChartCached(input);
        final String expected = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s", //
			"Hehe&%$125Bebe55%%",  //
			"\"H\" - 1",  //
			"\"e\" - 4",  //
			"\"h\" - 1",  //
			"\"&\" - 1",  //
			"\"%\" - 3",  //
			"\"$\" - 1",  //
			"\"1\" - 1",  //
			"\"2\" - 1",  //
			"\"5\" - 3",  //
			"\"B\" - 1",  //
			"\"b\" - 1");
    assertEquals(expected, actual);
    }
}
