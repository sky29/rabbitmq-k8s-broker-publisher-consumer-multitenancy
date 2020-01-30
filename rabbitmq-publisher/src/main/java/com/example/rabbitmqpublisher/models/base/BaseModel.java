package com.example.rabbitmqpublisher.models.base;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public abstract class BaseModel {

    @Getter @Setter
    private String tenantId;

    @Getter @Setter
    private String exchange;

    @Getter @Setter
    private String routingKey;

    @Getter @Setter
    private String queue;
}