package com.ani.gatway.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ani.gatway.service.kafkaPublisherService;

@RestController
public class kafkaPublisherController {

	@Autowired
	public kafkaPublisherService kafkaPublisherService;
	
	@GetMapping("/message")
	public ResponseEntity<String> sendMessage() throws InterruptedException, ExecutionException{
		kafkaPublisherService.sendMessage();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
}
