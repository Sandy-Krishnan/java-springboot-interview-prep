package com.example.textformatter;

import com.example.service.TextFormatterService;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TextFormatter implements TextFormatterService {

    public String countWordFrequency(String input) {
        if (input == null || input.isEmpty()) {
            return "No words to count.";
        }

        Map<String, Long> wordCount = Arrays.stream(input.split("[^A-Za-z]+"))
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n"));
  }
}
