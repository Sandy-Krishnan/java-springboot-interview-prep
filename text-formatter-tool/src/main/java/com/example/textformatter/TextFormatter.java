package com.example.textformatter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextFormatter {
    public static String countWordFrequency(String input) {
        if (input == null || input.isEmpty()) {
            return "No words to count.";
        }

        Map<String, Long> wordCount = Arrays.stream(input.split("[^A-za-z]+"))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return wordCount.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n"));
  }
}
