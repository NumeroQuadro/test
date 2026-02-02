package com.example.testservice.controller;

import com.example.testservice.service.TimeService;
import java.time.Instant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PingController {

    private final TimeService timeService;

    public PingController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/ping")
    public PingResponse ping() {
        return new PingResponse("ok", timeService.now());
    }

    public record PingResponse(String status, Instant time) {
    }
}
