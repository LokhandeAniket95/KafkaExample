package com.ani.gatway.service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class kafkaPublisherService {
	
	private static final Logger log = LoggerFactory.getLogger(kafkaPublisherService.class);
	
	@Autowired
	public KafkaTemplate<String, Object> template;
	
	public void sendMessage() throws InterruptedException, ExecutionException {
		for (int i = 0; i < 500; i++) {
			long nextLong = new Random().nextLong();
			SendResult<String, Object> sendResult = template.send("test-topic", nextLong+"").get();
			log.info("Create order {} event sent via Kafka", sendResult);
		    log.info(sendResult.toString());
		}
		
		
	}

}
