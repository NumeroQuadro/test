package com.example.testservice.service.impl;

import com.example.testservice.dto.EchoRequest;
import com.example.testservice.dto.EchoResponse;
import com.example.testservice.repository.MessageRepository;
import com.example.testservice.service.EchoService;
import com.example.testservice.service.TimeService;
import org.springframework.stereotype.Service;

@Service
public class EchoServiceImpl implements EchoService {

    private final TimeService timeService;
    private final MessageRepository messageRepository;

    public EchoServiceImpl(TimeService timeService, MessageRepository messageRepository) {
        this.timeService = timeService;
        this.messageRepository = messageRepository;
    }

    @Override
    public EchoResponse echo(EchoRequest request) {
        messageRepository.save(request.message());
        return new EchoResponse(request.message(), timeService.now());
    }
}
