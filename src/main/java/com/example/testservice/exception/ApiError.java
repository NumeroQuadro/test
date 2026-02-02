package com.example.testservice.exception;

import java.time.Instant;

public record ApiError(String code, String message, String path, Instant timestamp) {
}
