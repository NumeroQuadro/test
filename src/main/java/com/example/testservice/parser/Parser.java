package com.example.testservice.parser;

public interface Parser<T> {
    T parse(String input);
}
