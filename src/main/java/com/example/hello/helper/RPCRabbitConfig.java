package com.example.hello.helper;

import com.student.app.service.StudentService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.remoting.client.AmqpProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class RPCRabbitConfig {
    @Bean
    public Queue queue() {
        return new Queue("rpc.requests");
    }

    @Bean
    public StudentService amqpFactoryBean(AmqpTemplate amqpTemplate) {
        AmqpProxyFactoryBean factoryBean = new AmqpProxyFactoryBean();
        factoryBean.setServiceInterface(StudentService.class);
        factoryBean.setAmqpTemplate(amqpTemplate);
        factoryBean.setRoutingKey("rpc");
        factoryBean.afterPropertiesSet();
        return (StudentService) factoryBean.getObject();
    }

    @Bean
    public Exchange directExchange(Queue queue) {
        DirectExchange exchange = new DirectExchange("req.rpc");
        BindingBuilder.bind(queue).to(exchange).with("rpc");
        return exchange;
    }

    @Bean
    public RabbitTemplate amqpTemplate(ConnectionFactory factory) {
        RabbitTemplate template = new RabbitTemplate(factory);
        return template;
    }
}
