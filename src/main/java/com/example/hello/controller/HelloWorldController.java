package com.example.hello.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.core.Queue;

@RestController
@RequestMapping("/api/v1/")
public class HelloWorldController {
    private RabbitTemplate template;

    private Queue queue;

    private HelloWorldController(Queue queue, RabbitTemplate template) {
        super();
        this.queue = queue;
        this.template = template;
    }

    @GetMapping("hello/")
    public String helloWorld(){
        String message = "Hello World!";
        template.convertAndSend(queue.getName(), message);
        return "Message has been sent successfully!";
    }
}
