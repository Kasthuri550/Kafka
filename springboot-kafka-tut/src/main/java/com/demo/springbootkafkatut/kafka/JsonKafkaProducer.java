package com.demo.springbootkafkatut.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.demo.springbootkafkatut.payload.User;

@Service
public class JsonKafkaProducer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String,User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User user)
	{
		LOGGER.info("Message sent -> {}",user.toString());
		Message<User> message=MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC,"json_topic")
				.build();
		
		kafkaTemplate.send(message);
	}

}
