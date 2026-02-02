package com.example.testservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.testservice.service.TimeService;
import java.time.Instant;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PingControllerTest {

    @Test
    void pingReturnsOkAndTimestamp() {
        TimeService timeService = Mockito.mock(TimeService.class);
        Instant fixedTime = Instant.parse("2025-01-01T00:00:00Z");
        when(timeService.now()).thenReturn(fixedTime);

        PingController controller = new PingController(timeService);
        PingController.PingResponse response = controller.ping();

        assertEquals("ok", response.status());
        assertEquals(fixedTime, response.time());
    }
}
