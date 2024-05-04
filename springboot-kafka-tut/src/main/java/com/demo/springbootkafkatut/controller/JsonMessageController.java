package com.demo.springbootkafkatut.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootkafkatut.kafka.JsonKafkaProducer;
import com.demo.springbootkafkatut.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	
	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		super();
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody	User user)
	{
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("JSON Message sent to kafka topic");
	}

}
