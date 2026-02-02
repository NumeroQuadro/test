package com.example.testservice.dto;

import java.time.Instant;

public record EchoResponse(String message, Instant timestamp) {
}
