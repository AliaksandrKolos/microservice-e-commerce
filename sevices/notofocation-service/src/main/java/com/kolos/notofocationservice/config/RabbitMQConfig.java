package com.kolos.notofocationservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.order-confirmation}")
    private String orderConfirmationQueueName;

    @Value("${rabbitmq.queue.payment-notification}")
    private String paymentNotificationQueueName;

    @Value("${rabbitmq.exchange.direct}")
    private String directExchangeName;

    @Value("${rabbitmq.routing-key.order-confirmation}")
    private String orderConfirmationRoutingKey;

    @Value("${rabbitmq.routing-key.payment-notification}")
    private String paymentNotificationRoutingKey;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue orderConfirmationQueue() {
        return new Queue(orderConfirmationQueueName, false);
    }

    @Bean
    public Queue paymentNotificationQueue() {
        return new Queue(paymentNotificationQueueName, false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directExchangeName);
    }

    @Bean
    public Binding orderConfirmationBinding(Queue orderConfirmationQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(orderConfirmationQueue)
                .to(directExchange)
                .with(orderConfirmationRoutingKey);
    }

    @Bean
    public Binding paymentNotificationBinding(Queue paymentNotificationQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(paymentNotificationQueue)
                .to(directExchange)
                .with(paymentNotificationRoutingKey);
    }
}
