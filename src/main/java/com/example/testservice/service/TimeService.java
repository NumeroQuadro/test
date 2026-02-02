package com.example.testservice.service;

import java.time.Clock;
import java.time.Instant;
import org.springframework.stereotype.Component;

@Component
public class TimeService {

    private final Clock clock;

    public TimeService(Clock clock) {
        this.clock = clock;
    }

    public Instant now() {
        return Instant.now(clock);
    }
}
