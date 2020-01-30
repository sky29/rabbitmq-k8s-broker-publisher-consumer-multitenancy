package com.example.rabbitmqpublisher.services.mq;

import com.example.rabbitmqpublisher.models.base.BaseModel;
import com.example.rabbitmqpublisher.models.helloworld.HelloworldModel;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloworldMessageSender implements MessageSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public void sendMessage(BaseModel baseModel) {
		HelloworldModel helloworldModel = (HelloworldModel) baseModel;
		this.amqpTemplate.convertAndSend(helloworldModel.getExchange(), helloworldModel.getRoutingKey(), helloworldModel.getMessage());
	}
	
}