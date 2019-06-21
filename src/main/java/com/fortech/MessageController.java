package com.fortech;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
    private  MessageProducer messageProducer;
	@Autowired 
	private MessageConsumer messageConsumer;

    @GetMapping
    public List<String> view() {
        return messageConsumer.messages;
    }
    
    @PostMapping(value="/message")
    @ResponseStatus(value= HttpStatus.CREATED)
    public void sendMessage(@RequestBody String message) {
        messageProducer.sendMessage(message);
    }
    
}
