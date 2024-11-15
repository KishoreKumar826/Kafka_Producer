package com.example.kafka_Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@SpringBootApplication
@RestController
public class KafkaProducerApplication {
	@Autowired
	private KafkaTemplate<String, String> KafkaTemplate;
	@GetMapping("/message/{message}")
	public String publish(@PathVariable String message) {
		KafkaTemplate.send("demo1",message,message);
		return new String();
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
		System.out.println("Producer started");
	}

}
