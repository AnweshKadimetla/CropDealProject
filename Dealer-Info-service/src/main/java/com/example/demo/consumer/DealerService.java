package com.example.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.example.demo.config.MessageingConfig;
import com.example.demo.entity.OrderStatus;

public class DealerService {
	@RabbitListener(queues = MessageingConfig.QUEUE)
	public void consumeMessageFromQueue(OrderStatus orderStatus) {
		System.out.println("Message recived from the queue:"+orderStatus);
		
	}

}
