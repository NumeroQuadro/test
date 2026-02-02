package com.example.testservice.parser;

import java.util.LinkedHashMap;
import java.util.Map;

public class KeyValueParser implements Parser<Map<String, String>> {

    @Override
    public Map<String, String> parse(String input) {
        if (input == null) {
            throw new ParserException("input is null");
        }

        Map<String, String> result = new LinkedHashMap<>();
        String[] lines = input.split("\\r?\\n");

        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }

            int separatorIndex = trimmed.indexOf('=');
            if (separatorIndex <= 0) {
                throw new ParserException("invalid line: " + line);
            }

            String key = trimmed.substring(0, separatorIndex).trim();
            String value = trimmed.substring(separatorIndex + 1).trim();

            if (key.isEmpty()) {
                throw new ParserException("empty key");
            }

            result.put(key, value);
        }

        return result;
    }
}
