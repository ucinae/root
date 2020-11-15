package com.ucinae.root.consumer;

import com.ucinae.root.config.RabbitConstructor;
import com.ucinae.root.constants.RabbitConstants;
import com.ucinae.root.dto.RabbitDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitConsumer implements RabbitConsumerInterface {
    private final RabbitConstructor rabbitConstructor;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(
            queues = RabbitConstants.RABBIT.QUEUE,
            id = RabbitConstants.RABBIT.LISTENER,
            containerFactory = RabbitConstants.CONTAINER_FACTORY
    )
    public void rabbitConsumer(RabbitDto rabbitDto, @Header(value = "x-redelivered-count", required = false) Integer count) {

        int nextCount = count == null ? 1 : count + 1;

        if (nextCount > 5) {
            log.info("count over 5..");
            return;
        }

        log.info("** count = {}", count);
        log.info("** rabbitDto = {}", rabbitDto);

        rabbitTemplate.convertAndSend(
                RabbitConstants.EXCHANGE,
                RabbitConstants.RABBIT.ROUTING_KEY,
                rabbitDto,
                p -> {
                    p.getMessageProperties().setDelay(5 * 1000);
                    p.getMessageProperties().setHeader("x-redelivered-count", nextCount);
                    return p;
                }
        );
    }

    @Override
    public void declare() {
        rabbitConstructor.declareWithDelay(
                RabbitConstants.EXCHANGE,
                RabbitConstants.RABBIT.ROUTING_KEY,
                RabbitConstants.RABBIT.QUEUE
        );
    }
}
