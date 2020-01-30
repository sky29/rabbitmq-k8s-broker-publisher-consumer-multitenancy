package com.example.rabbitmqpublisher.controllers.helloworld;

import com.example.rabbitmqpublisher.services.helloworld.HelloworldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldControllerImpl implements HelloworldController {

    @Autowired
    private HelloworldService helloworldService;

    @Override
    @GetMapping("/send")
    public void sendMessage() {
        helloworldService.sendMessage();
        System.out.println("Messages sent");
    }
   
}