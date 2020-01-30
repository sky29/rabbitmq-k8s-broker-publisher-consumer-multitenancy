package com.example.rabbitmqpublisher.models.helloworld;

import com.example.rabbitmqpublisher.models.base.BaseModel;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Data
@NoArgsConstructor
public class HelloworldModel extends BaseModel {

    @Getter @Setter
    private String message = "Hello World";

}