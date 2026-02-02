package com.example.testservice.repository;

import java.util.List;

public interface MessageRepository {
    void save(String message);
    List<String> findAll();
}
