package com.helpcenter.event;

import com.helpcenter.events.gateway.IEventGateway;
import com.helpcenter.events.model.Event;
import com.helpcenter.rabbitmq.RabbitMqConfiguration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventsGateway implements IEventGateway {

    private final Logger logger = LoggerFactory.getLogger(EventsGateway.class);
    private final RabbitTemplate rabbitTemplate;
    private final MessageConverter messageConverter;

    @Override
    public void emitEvent(Event event) {
        rabbitTemplate.setMessageConverter(messageConverter);
        logger.info("Assignees event emitted");
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.TOPIC_EXCHANGE,
                RabbitMqConfiguration.ROUTING_KEY_EVENTS_GENERAL, event);
    }
}
