package com.fortech;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAmqpConfig {

	String exchangeName = "com.fortech.fanout";

	@Bean
	public FanoutExchange exchange() {
		return new FanoutExchange(exchangeName);
	}

	@Bean
	public Queue autoDeleteQueue() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding binding(FanoutExchange fanout, Queue autoDeleteQueue) {
		return BindingBuilder.bind(autoDeleteQueue).to(fanout);
	}

}