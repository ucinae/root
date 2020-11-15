package com.ucinae.root.controller;

import com.ucinae.root.consumer.RabbitConsumerInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/amqp")
@RequiredArgsConstructor
public class RabbitIndicator {

    private final List<RabbitConsumerInterface> amqpConsumerInterfaceList;
    private final RabbitListenerEndpointRegistry endpointRegistry;

    @PutMapping("/start")
    public ResponseEntity<?> startConsumer() {
        amqpConsumerInterfaceList.forEach(RabbitConsumerInterface::declare);
        endpointRegistry.start();
        log.info("Amqp Registry Started");
        return ResponseEntity.ok("Started");
    }

    @PutMapping("/stop")
    public ResponseEntity<?> stopConsumer() {
        endpointRegistry.stop();
        log.info("Amqp Registry Stopped");
        return ResponseEntity.ok("Stopped");
    }

    @PostMapping("/declare")
    public ResponseEntity<?> declareQueues() {
        amqpConsumerInterfaceList.forEach(RabbitConsumerInterface::declare);
        return ResponseEntity.ok("Declared");
    }
}