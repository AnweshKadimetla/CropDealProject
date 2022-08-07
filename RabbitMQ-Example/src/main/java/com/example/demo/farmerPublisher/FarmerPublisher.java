package com.example.demo.farmerPublisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Farmer;
import com.example.demo.Entity.FarmerStatus;
import com.example.demo.config.MessagingConfig;

@RestController
@RequestMapping("/farmer")
public class FarmerPublisher {
		@Autowired
		private RabbitTemplate template;
		@PostMapping("/{location}")
		public String bookCrop(@RequestBody Farmer farmer , @PathVariable String location) {
			farmer.setFarmerId(UUID.randomUUID().toString());
			FarmerStatus farmerStatus = new FarmerStatus(farmer,"PROCESS","Crop details reached successfully in "+location);
			template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, farmerStatus);
			return "Success!!";
		}
}
