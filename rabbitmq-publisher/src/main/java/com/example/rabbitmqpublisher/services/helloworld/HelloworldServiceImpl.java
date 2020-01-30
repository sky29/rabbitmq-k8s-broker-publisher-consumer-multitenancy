package com.example.rabbitmqpublisher.services.helloworld;

import com.example.rabbitmqpublisher.models.helloworld.HelloworldModel;
import com.example.rabbitmqpublisher.services.mq.HelloworldMessageSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloworldServiceImpl implements HelloworldService {

    @Autowired
    private HelloworldMessageSender helloworldMessageSender;

    
    @Override
    public void sendMessage() {
        for (int i=1; i<=10;i++) {
            helloworldMessageSender.sendMessage(getHelloworldModelForTenantOne());
        }

        for (int i=1; i<=10;i++) {
            helloworldMessageSender.sendMessage(getHelloworldModelForTenantTwo());
        }
    }

    HelloworldModel getHelloworldModelForTenantOne(){
        HelloworldModel helloworldModelForTenantOne = new HelloworldModel();
        helloworldModelForTenantOne.setTenantId("t1");
        helloworldModelForTenantOne.setExchange("helloworld_exchange");
        helloworldModelForTenantOne.setRoutingKey("helloworld_routing_key_t1");
        helloworldModelForTenantOne.setMessage("Helloworld from Tenant 1");
        return helloworldModelForTenantOne;
    }


    HelloworldModel getHelloworldModelForTenantTwo(){
        HelloworldModel helloworldModelForTenantTwo = new HelloworldModel();
        helloworldModelForTenantTwo.setTenantId("t2");
        helloworldModelForTenantTwo.setExchange("helloworld_exchange");
        helloworldModelForTenantTwo.setRoutingKey("helloworld_routing_key_t2");
        helloworldModelForTenantTwo.setMessage("Helloworld from Tenant 2");
        return helloworldModelForTenantTwo;
    }

}