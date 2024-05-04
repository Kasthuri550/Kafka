package com.demo.springbootkafkatut.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.springbootkafkatut.payload.User;

@Service
public class JsonKafkaConsumer {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "json_topic",groupId = "myGroup")
	public void consume(User user)
	{
		LOGGER.info("Json message received -> {}",user.toString());
	}

}
