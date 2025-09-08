package com.example.textfromatter;


import com.example.textformatter.TextFormatter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextFormatterTest {

    @Test
    public void testCountWordFrequency() {

        TextFormatter textFormatter = new TextFormatter();

        String input  = "Hello world! Hello everyone. Welcome to the world of Java.";
        String expectedResult = "everyone: 1\nhello: 2\njava: 1\nof: 1\nthe: 1\nto: 1\nwelcome: 1\nworld: 2";

        String actualResult = textFormatter.countWordFrequency(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWordFrequency_EmptyInput() {
        TextFormatter textFormatter = new TextFormatter();

        String input = "";
        String expectedResult = "No words to count.";

        String actualResult = textFormatter.countWordFrequency(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWordFrequency_NullInput() {
        TextFormatter textFormatter = new TextFormatter();

        String input = null;
        String expectedResult = "No words to count.";

        String actualResult = textFormatter.countWordFrequency(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWordFrequency_SpecialCharacters() {
        TextFormatter textFormatter = new TextFormatter();

        String input = "Hello, world! Hello... everyone??? Welcome to the world of Java.";
        String expectedResult = "everyone: 1\nhello: 2\njava: 1\nof: 1\nthe: 1\nto: 1\nwelcome: 1\nworld: 2";

        String actualResult = textFormatter.countWordFrequency(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWordFrequency_CaseInsensitivity() {
        TextFormatter textFormatter = new TextFormatter();

        String input = "Hello hello HeLLo hELlo";
        String expectedResult = "hello: 4";

        String actualResult = textFormatter.countWordFrequency(input);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountWordFrequency_NumbersAndSymbols() {
        TextFormatter textFormatter = new TextFormatter();

        String input = "Hello 123 world! @Hello #everyone $Welcome %to ^the &world *of (Java).";
        String expectedResult = "everyone: 1\nhello: 2\njava: 1\nof: 1\nthe: 1\nto: 1\nwelcome: 1\nworld: 2";

        String actualResult = textFormatter.countWordFrequency(input);

        assertEquals(expectedResult, actualResult);
    }

}
