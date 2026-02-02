package com.example.testservice.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;

class KeyValueParserTest {

    private final KeyValueParser parser = new KeyValueParser();

    @Test
    void parsesKeyValueLines() {
        String input = "name=service\nversion=1\n";
        Map<String, String> result = parser.parse(input);

        assertEquals(2, result.size());
        assertEquals("service", result.get("name"));
        assertEquals("1", result.get("version"));
    }

    @Test
    void ignoresBlankLines() {
        String input = "\nname=service\n\n";
        Map<String, String> result = parser.parse(input);

        assertEquals(1, result.size());
        assertEquals("service", result.get("name"));
    }

    @Test
    void throwsOnInvalidLine() {
        String input = "name=service\ninvalid\n";

        ParserException exception = assertThrows(ParserException.class, () -> parser.parse(input));
        assertEquals("invalid line: invalid", exception.getMessage());
    }
}
