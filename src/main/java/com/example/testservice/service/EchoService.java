package com.example.testservice.service;

import com.example.testservice.dto.EchoRequest;
import com.example.testservice.dto.EchoResponse;

public interface EchoService {
    EchoResponse echo(EchoRequest request);
}
