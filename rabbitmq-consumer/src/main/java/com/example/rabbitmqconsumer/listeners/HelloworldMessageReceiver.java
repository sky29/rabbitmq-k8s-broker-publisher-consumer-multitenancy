package com.example.rabbitmqconsumer.listeners;

import com.example.rabbitmqconsumer.listeners.MessageReceiver;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloworldMessageReceiver implements MessageReceiver {

	@Override
	//@RabbitListener(queues = "helloworld_queue_t3")
	@RabbitListener(queues = "#{'${helloworld.queues}'.split(',')}")
	public void receiveMessage(String message) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Received Message from HelloworldMessageReceiver: " + message);
	}
	
}