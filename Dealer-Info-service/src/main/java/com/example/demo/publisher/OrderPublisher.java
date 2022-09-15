package com.example.demo.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.config.MessageingConfig;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderStatus;
//import com.rabbitmq.client.AMQP.Exchange;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

	@Autowired 
	private RabbitTemplate template;
	
	@PostMapping("/{location}")
	public String cropOrder(@RequestBody Order order,@PathVariable String location) {
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderStatus orderStatus=new OrderStatus(order,"PROCESS","order placed successfully to "+location);
		template.convertAndSend(MessageingConfig.EXCHANGE,MessageingConfig.ROUTING_KEY , orderStatus);
		return "Done";
	}
}
