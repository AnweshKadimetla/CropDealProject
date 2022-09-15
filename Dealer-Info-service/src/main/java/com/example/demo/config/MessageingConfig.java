package com.example.demo.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
//import org.springframework.cloud.function.context.config.JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageingConfig { 
	
	public static final String QUEUE ="CropDeal_queue";
	public static final String EXCHANGE="CropDeal_exchange";
	public static final String ROUTING_KEY="CropDeal_routingkey";
	
	
	@Bean
	 Queue queue() {
		return new Queue("QUEUE");
	}
	@Bean
	 TopicExchange exchange() {
		return new TopicExchange("CropDeal_exchange");
	}

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("ROUTING_KEY");
    }
    
    @Bean
    MessageConverter converter() {
    	return new Jackson2JsonMessageConverter();    	
    }
    
    @Bean
    AmqpTemplate template(ConnectionFactory connectionFactory) {
    	final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    	rabbitTemplate.setMessageConverter(converter());
    	return rabbitTemplate;
    }
}
