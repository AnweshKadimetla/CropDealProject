package com.example.demo.admin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.admin.exception.DataAlreadyExists;
import com.example.demo.admin.farmerentity.FarmerEntity;
import com.example.demo.admin.farmerrepository.FarmerRepos;
import com.example.demo.admin.farmerservice.FarmerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceApplicationTests {

	@Autowired
	FarmerService service;
	
//	private MockMvc mockMvc;
//	
//	@Autowired
//	private WebApplicationContext context;
	
	//FarmerEntity farmer=new FarmerEntity();
	
	@MockBean
	FarmerRepos repo;
	
//	@BeforeEach
//	public void setUp() throws Exception {
//		super.setUp();
//	}
	
	@Test
	public void addFarmerInfo() throws DataAlreadyExists {
		FarmerEntity farmer = new FarmerEntity(3,"Ganpat","Lal",23451,"Pune");
		when(repo.save(farmer)).thenReturn(farmer);
		assertEquals(farmer, service.addFarmerInfo(farmer));
		
	}

	@Test
	public void deleteFarmerInfoTest() {
		FarmerEntity farmer = new FarmerEntity();
		farmer.setFirstName("Ram");
		farmer.setId(1);
		
		when(repo.findById(farmer.getId())).thenReturn(Optional.of(farmer));
		service.deleteFarmerInfo(farmer.getId());
		verify(repo).deleteById(farmer.getId());
		
	}
	
	@Test
	public void getFarmerByIdTest() {
		FarmerEntity farmer = new FarmerEntity();
		farmer.setId(2);
		
		when(repo.findById(farmer.getId())).thenReturn(Optional.of(farmer));
		FarmerEntity expected = service.getFarmerById(farmer.getId());
		assertThat(expected).isSameAs(farmer);
		verify(repo).findById(farmer.getId());
	}
	
//	@Test
//	public void getAllFarmer() {
//		List<FarmerEntity> farmer = (List<FarmerEntity>) new FarmerEntity(3,"Ganpat","Lal",23451,"Pune");
//		when(repo.findAll()).thenReturn(farmer);
//		assertEquals(farmer, service.getFarmerInfo());
//	}
//	@Test
//	public void getAllFarmers() throws Exception{
//		String uri="/farmers/findAll";
//		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
//		assertEquals(200,mvcResult.getResponse().getStatus());
//	}
	
//	ObjectMapper om=new ObjectMapper();
//	
//	@BeforeEach
//	public void setup() {
//		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
//	}
//	
//	public void addFarmerInfo() throws Exception {
//		FarmerEntity farmer =new FarmerEntity();
//		farmer.setId(1);
//		farmer.setFirstName("Basant");
//		farmer.setLastName("Lal");
//		farmer.setAddress("bihar");
//		farmer.setPhoneNumber(1234);
//		String jsonRequest=om.writeValueAsString(farmer);
//		MvcResult result=mockMvc.perform(post("/farmers/addFarmer").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
//		String resultContent=result.getResponse().getContentAsString();
//		Response response=om.readValue(resultContent, Response.class);
//		Assert.assertTrue(resultContent, false);
//	
//	}
	
	
//	@BeforeEach
//	void setup() {
//		Optional<FarmerEntity> farmer=Optional.of(new FarmerEntity(1,"Raj","jod",2314,"maha"));
//		Mockito.when(repo.findById(1)).thenReturn(farmer);
//	}
//	
//	@Test
//	public void getFarmerById() {
//		String farmerName = "Raj";
//		FarmerEntity farmerById =service.getFarmerById(1);
//		assertEquals(farmerName, farmerById.getFirstName());
//	}

//	@Test
//	public void deleteFarmerInfo(int id) {
//		FarmerEntity farmer = new FarmerEntity(3,"Ganpat","Lal",23451,"Pune");
//		service.deleteFarmerInfo(id);
//		verify(repo,times(id)).deleteById(id);
//	}
}
