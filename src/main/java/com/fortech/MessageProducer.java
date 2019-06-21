package com.fortech;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

	@Autowired
    RabbitTemplate rabbitTemplate;    
    @Autowired
	FanoutExchange fanoutExchange;
    

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
    }
}