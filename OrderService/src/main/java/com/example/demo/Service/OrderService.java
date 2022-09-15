package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Order;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.common.Payment;
import com.example.demo.common.TxResponse;

@Service
public class OrderService {
	
	 @Autowired
	    private OrderRepository orderRepository;

	    @Autowired
	    private RestTemplate template;

	    public TxResponse placeOrder(Order order){
	    	orderRepository.save(order);
	        Payment paymentReq = new Payment();
	        paymentReq.setOrderId(order.getId());
	        paymentReq.setAmount(order.getQuantity()*order.getPrice());
	        //restTemplate
	        Payment paymentRes =
	                template.postForObject("http://localhost:9100/payment/doPay/",
	                paymentReq, Payment.class);
	        TxResponse txResponse = new TxResponse();
	        txResponse.setOrder(order);
	        txResponse.setStatus(paymentRes.getPaymentStatus());
	        txResponse.setAmount(paymentRes.getAmount());
	        txResponse.setTxId(paymentRes.getTxId());
	        return txResponse;
	    }

}
