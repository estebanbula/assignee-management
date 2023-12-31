package com.helpcenter.rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class RabbitMqConfiguration {

    @Value("${adapters.rabbitmq.host}")
    private String rabbitHost;
    @Value("${adapters.rabbitmq.username}")
    private String rabbitUsername;
    @Value("${adapters.rabbitmq.password}")
    private String rabbitPwd;
    @Value("${adapters.rabbitmq.port}")
    private Integer rabbitPort;

    public static final String TOPIC_EXCHANGE = "assignees-topic-exchange";
    public static final String QUEUE_EVENTS_GENERAL = "assignees.events.general";
    public static final String ROUTING_KEY_EVENTS_GENERAL = "assignees.routing.key.events.#";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_EVENTS_GENERAL);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(ROUTING_KEY_EVENTS_GENERAL);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Connection rabbitConnection() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(rabbitHost);
        connectionFactory.setPort(rabbitPort);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername(rabbitUsername);
        connectionFactory.setPassword(rabbitUsername);
        return connectionFactory.newConnection();
    }
}
