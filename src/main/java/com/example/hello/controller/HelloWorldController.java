package com.example.hello.controller;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.core.Queue;

@RestController
@RequestMapping("/api/v1/")
public class HelloWorldController {
//    @Autowired
//    private RabbitTemplate template;
//
//    @Autowired
//    private DirectExchange exchange;
//
//
//    @Autowired
//    private Queue queue;
//
//    @GetMapping("hello/")
//    public String helloWorld(){
//        String message = "Hello World!";
//        template.convertAndSend(queue.getName(), message);
//        return "Message has been sent successfully!";
//    }
}
