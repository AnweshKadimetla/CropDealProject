package com.example.demo.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.CartEntity;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CartInfoServiceApplicationTests {

	@Autowired
	CartService service;
	
	@MockBean
	CartRepository repo;
	
//	@Test
//	public void addtoCart() {
//		CartEntity cart =new CartEntity(1,"Carrot", "vegetable", 200,"mumbai", 10);
//		when(repo.save(cart)).thenReturn(cart);
//		assertEquals(cart, service.addCartEntityInfo(cart));
//	}
	
	@Test
	public void delete() {
		CartEntity cart =new CartEntity();
		cart.setId(1);
		cart.setCropName("Carrot");
		
		when(repo.findById(cart.getId())).thenReturn(Optional.of(cart));
		service.deleteCartEntityInfo(cart.getId());
		verify(repo).deleteById(cart.getId());
	}
	

}
