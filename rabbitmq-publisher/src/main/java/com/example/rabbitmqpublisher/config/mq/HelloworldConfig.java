package com.example.rabbitmqpublisher.config.mq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableRabbit
public class HelloworldConfig extends BaseMqConfig {

	@Value("${helloworld.exchange}")
	private String helloworldExchange;

	@Value("${helloworld.queue}")
	private String helloworldQueue;

	@Value("${helloworld.routing.key}")
	private String helloworldRoutingKey;

	@Value("${tenant.id.one}")
	private String tenantOne;

	@Value("${tenant.id.two}")
	private String tenantTwo;

	@Bean
	DirectExchange helloworldExchange() {
		return new DirectExchange(helloworldExchange, true, false);
	}

	@Bean
	Queue helloworldQueueTenantOne() {
		return new Queue(getTenantSpecificQueue(helloworldQueue,tenantOne), true, false, false);
	}

	@Bean
	Queue helloworldQueueTenantTwo() {
		return new Queue(getTenantSpecificQueue(helloworldQueue,tenantTwo), true, false, false);
	}

	@Bean
	Binding helloworldBindingTenantOne() {
		return BindingBuilder.bind(helloworldQueueTenantOne()).to(helloworldExchange()).with(getTenantSpecificRoutingKey(helloworldRoutingKey,tenantOne));
	}

	@Bean
	Binding helloworldBindingTenantTwo() {
		return BindingBuilder.bind(helloworldQueueTenantTwo()).to(helloworldExchange()).with(getTenantSpecificRoutingKey(helloworldRoutingKey,tenantTwo));
	}

	private String getTenantSpecificQueue(String queueName,String tenantId) {
		System.out.println(queueName + "_" + tenantId);
		return queueName + "_" + tenantId;
	}

	private String getTenantSpecificRoutingKey(String routingKey,String tenantId) {
		System.out.println(routingKey + "_" + tenantId);
		return routingKey + "_" + tenantId;
	}

}