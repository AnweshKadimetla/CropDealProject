package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.exception.DataAlreadyExists;
import com.example.demo.farmerEntity.Farmer;
import com.example.demo.farmerRepository.FarmerRepository;
import com.example.demo.farmerService.FarmerService;
@RunWith(SpringRunner.class)
@SpringBootTest
class FarmerServiceApplicationTests {
	
	@Autowired
	public FarmerService farmerService;
	
	@MockBean
	private FarmerRepository farmerRepository;

	//private Farmer newFarmer;
	@Test
	public void addFarmerInfoTest()throws DataAlreadyExists {
		Farmer farmer = new Farmer(5, "Fruit","Mango" ,"120", 9999, "Hyderabad");// stub-> dummy data
		when(farmerRepository.save(farmer)).thenReturn(farmer);
		assertEquals(farmer, farmerService.addFarmerInfo(farmer));	
	}
	@Test
    public void deleteFarmerInfoTest(){
		Farmer farmer = new Farmer();
		farmer.setName("Test Name");
		farmer.setId(1);
        when(farmerRepository.findById(farmer.getId())).thenReturn(Optional.of(farmer));

        farmerService.deleteFarmerInfo(farmer.getId());
        verify(farmerRepository).deleteById(farmer.getId());
    }
//	 @Test
//	   	public void UpdateFarmerTest() {
//		 Farmer farmer = new Farmer();
//		 	farmer.setId(1);
//		 	farmer.setName("Test Name");
//
//		 	Farmer newFarmer = new Farmer();
//		 	farmer.setName("New Test Name");
//
//		 	given(farmerRepository.findById(farmer.getId())).willReturn(Optional.of(farmer));
//	        Optional<Farmer> excepted = farmerService.updateFarmerInfo(farmer.getId(), newFarmer);
//			assertThat(excepted).isSameAs(farmer);
//	        verify(farmerRepository).save(newFarmer);
//	        verify(farmerRepository).findById(farmer.getId());
//	    }
	
	@Test
    public void getFarmerByIdTest() {
		Farmer farmer = new Farmer();
		farmer.setId(2);//dummy data

        when(farmerRepository.findById
        		(farmer.getId())).thenReturn(Optional.of(farmer));

        Farmer expected = farmerService.getFarmerById(farmer.getId());

        assertThat(expected).isSameAs(farmer);
        verify(farmerRepository).findById(farmer.getId());
    }

	

}
