package com.techm.transport.vendor.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techm.transport.vendor.VendorApplication;
import com.techm.transport.vendor.controller.DriverController;
import com.techm.transport.vendor.entity.Vehicle;
import com.techm.transport.vendor.entity.VehicleType;
import com.techm.transport.vendor.service.DriverService;
import com.techm.transport.vendor.service.VehicleService;
import com.techm.transport.vendor.service.VehicleTypeService;
import com.techm.transport.vendor.service.VehicleVerificationService;


	//@SuppressWarnings("deprecation")
	@RunWith(SpringRunner.class)
	@WebMvcTest(value=com.techm.transport.vendor.test.VehicleTypeControllerTest.class)	
	@ContextConfiguration(classes={VendorApplication.class})
	public class VehicleTypeControllerTest {
		
		

		//VehicleController vc=new VehicleController();
		
	   @Autowired
		private MockMvc mockMvc;
	    
	    
		@MockBean
	    private VehicleTypeControllerTest vcontroller;
		
		
		@MockBean		
		private DriverService dservice;
		
		@MockBean		
		private VehicleTypeService vtservice;
		
		@MockBean		
		private VehicleVerificationService vvservice;
		
		@MockBean
		private VehicleService service;
		
		
		private JacksonTester<VehicleType> jsonSuperHero;
		
		VehicleType veht=new VehicleType(11, "train");
		
		
		
		@Before
		public void setup()
		{
			
			JacksonTester.initFields(this,new ObjectMapper()); 
		}
		@Test
		public void getVehicleTypeByName() throws Exception
		{
			
			Mockito.when(vtservice.getVecTypebyId(Mockito.anyInt())).thenReturn(veht); 
			
			
              MockHttpServletResponse result= mockMvc.perform(get("/1.0/vecType/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();	
              
              System.out.println("result is"+result.getContentAsString());
              assertThat(result.getStatus()).isEqualTo(HttpStatus.OK.value());
              
              assertThat(result.getContentAsString().equals(null));
		}
		
		
}
