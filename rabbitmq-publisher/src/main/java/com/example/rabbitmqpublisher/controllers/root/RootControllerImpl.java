package com.example.rabbitmqpublisher.controllers.root;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootControllerImpl implements RootController {

    @Override
    @GetMapping("/")
    public String showMessage() {
        return "Welcome to RabbitMQ Client - Publisher";
    }

    
}