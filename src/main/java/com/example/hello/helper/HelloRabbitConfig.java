package com.example.hello.helper;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HelloRabbitConfig {
    @Value("${rabbitapi.queue}")
    String queue_name;
    @Bean
    @Primary
    public Queue hello() {
        return new Queue("hello");
    }
}