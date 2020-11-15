package com.ucinae.root.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitConstructor {
    private final RabbitAdmin rabbitAdmin;

    public void declare(
            String exchangeName,
            String routingName,
            String queueName
    ) {
        log.info(
                "AmqpConstructor declare; exchangeName={}; routingName={}; queueName={};",
                exchangeName,
                routingName,
                queueName
        );

        Exchange exchange =
                ExchangeBuilder.directExchange(exchangeName)
                        .durable(true)
                        .build();
        rabbitAdmin.declareExchange(
                exchange
        );

        Queue queue =
                QueueBuilder.durable(queueName).build();
        rabbitAdmin.declareQueue(
                queue
        );

        rabbitAdmin.declareBinding(
                BindingBuilder.bind(queue).to(exchange).with(routingName).and(new HashMap<>())
        );
    }

    public void declareWithDelay(
            String exchangeName,
            String routingName,
            String queueName
    ) {

        log.info(
                "AmqpConstructor declareWithDelay; exchangeName={}; routingName={}; queueName={};",
                exchangeName,
                routingName,
                queueName
        );

        CustomExchange exchange =
                new CustomExchange(
                        exchangeName,
                        "x-delayed-message",
                        true,
                        false,
                        Collections.singletonMap("x-delayed-type", "direct")
                );
        rabbitAdmin.declareExchange(exchange);



        Queue queue =
                QueueBuilder.durable(queueName).build();
        rabbitAdmin.declareQueue(
                queue
        );



        rabbitAdmin.declareBinding(
                BindingBuilder.bind(queue).to(exchange).with(routingName).and(new HashMap<>())
        );
    }

    public void declareWithDlx(
            String exchangeName,
            String routingName,
            String queueName,
            String errorRoutingName,
            String errorQueueName,
            int ttl
    ) {
        log.info(
                "AmqpConstructor declareWithDlx; "
                        + "exchangeName={}; routingName={}; queueName={}; "
                        + "errorRoutingName=={}; errorQueueName={}; ttl={};",
                exchangeName,
                routingName,
                queueName,
                errorRoutingName,
                errorQueueName,
                ttl
        );

        Exchange exchange =
                ExchangeBuilder.directExchange(exchangeName)
                        .durable(true)
                        .build();
        rabbitAdmin.declareExchange(
                exchange
        );


        Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", ttl);
        args.put("x-dead-letter-exchange", exchangeName);
        args.put("x-dead-letter-routing-key", errorRoutingName);
        Queue queue =
                QueueBuilder.durable(queueName).withArguments(args).build();
        rabbitAdmin.declareQueue(
                queue
        );
        Queue errorQueue =
                QueueBuilder.durable(errorQueueName).build();
        rabbitAdmin.declareQueue(
                errorQueue
        );


        rabbitAdmin.declareBinding(
                BindingBuilder.bind(errorQueue).to(exchange).with(errorRoutingName).and(new HashMap<>())
        );
        rabbitAdmin.declareBinding(
                BindingBuilder.bind(queue).to(exchange).with(routingName).and(new HashMap<>())
        );
    }
}
