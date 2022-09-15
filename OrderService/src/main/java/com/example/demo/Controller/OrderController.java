package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;
import com.example.demo.common.TxResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder/")
    public TxResponse placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

}
