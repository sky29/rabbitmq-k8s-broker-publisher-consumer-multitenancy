package com.example.rabbitmqconsumer.listeners;

public interface MessageReceiver {

	void receiveMessage(String message);
}