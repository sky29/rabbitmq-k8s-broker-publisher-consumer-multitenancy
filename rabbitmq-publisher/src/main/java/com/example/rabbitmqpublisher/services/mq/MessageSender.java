package com.example.rabbitmqpublisher.services.mq;

import com.example.rabbitmqpublisher.models.base.BaseModel;

public interface MessageSender {

	void sendMessage(BaseModel baseModel);
	
}