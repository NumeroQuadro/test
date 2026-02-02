package com.example.testservice.repository;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMessageRepository implements MessageRepository {

    private final Queue<String> messages = new ConcurrentLinkedQueue<>();

    @Override
    public void save(String message) {
        messages.add(message);
    }

    @Override
    public List<String> findAll() {
        return List.copyOf(messages);
    }
}
