package com.fortech;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "#{autoDeleteQueue.name}")
public class MessageConsumer {

	List<String> messages = new ArrayList<>();

	@RabbitHandler
	public void receiveMessage(String message) {
		messages.add(message);
	}
}