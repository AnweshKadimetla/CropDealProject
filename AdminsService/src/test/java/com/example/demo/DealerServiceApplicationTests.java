//package com.example.demo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.example.demo.dealerEntity.Dealer;
//import com.example.demo.dealerRepository.DealerRepository;
//import com.example.demo.dealerService.DealerService;
//import com.example.demo.exception.DataAlreadyExists;
//import com.example.demo.farmerEntity.Farmer;
//import com.example.demo.farmerRepository.FarmerRepository;
//import com.example.demo.farmerService.FarmerService;
//
//@SpringBootTest
//class DealerServiceApplicationTests {
//	@Autowired
//	public DealerService dealerService;
//	
//	@MockBean
//	public DealerRepository dealerRepository;
//
//	@Test
//	public void addFarmerInfoTest()throws DataAlreadyExists {
//		Dealer dealer = new Dealer(1,"Hari","Krishna","hari@gmail.com",9515,"RLP");// stub-> dummy data
//		when(dealerRepository.save(dealer)).thenReturn(dealer);
//		assertEquals(dealer, dealerService.addDealerInfo(dealer));	
//	}
//	
//	
//
//	@Test
//    public void deleteFarmerInfoTest(){
//		Farmer farmer = new Farmer();
//		farmer.setFirstName("Test Name");
//		farmer.setId(1);
//        when(dealerRepository.findById(farmer.getId())).thenReturn(Optional.of(farmer));
//
//        dealerService.deleteDealerInfo(farmer.getId());
//        verify(dealerRepository).deleteById(farmer.getId());
//    }
////	 @Test
////	   	public void UpdateFarmerTest() {
////		 Farmer farmer = new Farmer();
////		 	farmer.setId(1);
////		 	farmer.setName("Test Name");
////
////		 	Farmer newFarmer = new Farmer();
////		 	farmer.setName("New Test Name");
////
////		 	given(farmerRepository.findById(farmer.getId())).willReturn(Optional.of(farmer));
////	        farmerService.updateFarmerInfo(farmer.getId(), newFarmer);
////
////	        verify(farmerRepository).save(newFarmer);
////	        verify(farmerRepository).findById(farmer.getId());
////	    }
////	private Object given(Optional<Farmer> findById) {
////		// TODO Auto-generated method stub
////		return null;
////	}
//	
//	@Test
//    public void getFarmerByIdTest() {
//		Farmer farmer = new Farmer();
//		farmer.setId(2);
//
//        when(dealerRepository.findById(farmer.getId())).thenReturn(Optional.of(farmer));
//
//        Farmer expected = farmerService.getFarmerById(farmer.getId());
//
//        assertThat(expected).isSameAs(farmer);
//        verify(dealerRepository).findById(farmer.getId());
//    }
//
//	
//
//}
