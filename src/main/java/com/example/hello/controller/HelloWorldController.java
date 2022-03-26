package com.example.hello.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class HelloWorldController {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @GetMapping("hello")
    public String helloWorld(){
        String message = "Hello World!";
        template.convertAndSend(queue.getName(), message);
        return "Message has been sent successfully!";
    }
}
