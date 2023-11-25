package com.ani.kafkalearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaListenerService {
	
	private static final Logger log = LoggerFactory.getLogger(KafkaListenerService.class);
	
	@KafkaListener(topics = "test-topic",groupId = "consumer-test1")
	public void consume(String message) {
		log.info("message consume {}", message);
	}

}
