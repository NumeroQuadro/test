package com.example.testservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.testservice.dto.EchoRequest;
import com.example.testservice.dto.EchoResponse;
import com.example.testservice.repository.MessageRepository;
import com.example.testservice.service.impl.EchoServiceImpl;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EchoServiceTest {

    @Mock
    private TimeService timeService;

    @Mock
    private MessageRepository messageRepository;

    private EchoService echoService;

    @BeforeEach
    void setUp() {
        echoService = new EchoServiceImpl(timeService, messageRepository);
    }

    @Test
    void echoReturnsMessageAndTimestamp() {
        Instant fixedTime = Instant.parse("2025-01-01T00:00:00Z");
        when(timeService.now()).thenReturn(fixedTime);

        EchoRequest request = new EchoRequest("hello");
        EchoResponse response = echoService.echo(request);

        assertEquals("hello", response.message());
        assertEquals(fixedTime, response.timestamp());
        verify(messageRepository).save("hello");
    }
}
