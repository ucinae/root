package com.ucinae.root.service;

import com.ucinae.root.constants.RabbitConstants;
import com.ucinae.root.dto.RabbitDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {
    private final RabbitTemplate rabbitTemplate;

    public void produce(RabbitDto rabbitDto) {
        rabbitTemplate.convertAndSend(
                RabbitConstants.EXCHANGE,
                RabbitConstants.RABBIT.ROUTING_KEY,
                rabbitDto
        );
    }

}
