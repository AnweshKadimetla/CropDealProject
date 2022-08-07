package com.example.demo.dealerConsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.FarmerStatus;
import com.example.demo.config.MessagingConfig;

@Component
public class DealerConsumer {
	@RabbitListener(queues = MessagingConfig.QUEUE)
	public void consumeMessageFromQueue(FarmerStatus fatmerStatus) {
		System.out.println("Message recieved from queue"+fatmerStatus);
	}

}
