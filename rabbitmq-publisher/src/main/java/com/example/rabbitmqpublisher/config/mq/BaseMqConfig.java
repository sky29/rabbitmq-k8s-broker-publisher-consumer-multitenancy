package com.example.rabbitmqpublisher.config.mq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class BaseMqConfig {

    @Value("${spring.rabbitmq.host}")
	private String rabbitMqHost;

	@Value("${spring.rabbitmq.port}")
	private int rabbitMqPort;

	@Value("${spring.rabbitmq.username}")
	private String rabbitMqUser;

	@Value("${spring.rabbitmq.password}")
    private String rabbitMqPassword;
    
    @Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(rabbitMqHost);
		connectionFactory.setPort(rabbitMqPort);
		connectionFactory.setUsername(rabbitMqUser);
		connectionFactory.setPassword(rabbitMqPassword);
		// connectionFactory.setPublisherConfirms(true);
		// connectionFactory.setPublisherReturns(true);
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		return new RabbitTemplate(connectionFactory());
	}
    
}