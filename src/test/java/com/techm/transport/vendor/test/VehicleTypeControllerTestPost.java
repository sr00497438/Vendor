package com.techm.transport.vendor.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techm.transport.vendor.VendorApplication;
import com.techm.transport.vendor.entity.VehicleType;
import com.techm.transport.vendor.service.DriverService;
import com.techm.transport.vendor.service.VehicleService;
import com.techm.transport.vendor.service.VehicleTypeService;
import com.techm.transport.vendor.service.VehicleVerificationService;


	//@SuppressWarnings("deprecation")
	@RunWith(SpringRunner.class)
	@WebMvcTest(value=com.techm.transport.vendor.test.VehicleTypeControllerTestPost.class)	
	@ContextConfiguration(classes={VendorApplication.class})
	public class VehicleTypeControllerTestPost {
		
		

		//VehicleController vc=new VehicleController();
		
	   @Autowired
		private MockMvc mockMvc;
	    
	    
		@MockBean
	    private VehicleTypeControllerTestPost vcontroller;
		
		
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
		public void getVehicleTypeNamePost() throws Exception
		{
		
			String exampleCourseJson = "{\"vId\":\"1\",\"vecTypeName\":\"train\"}";

			
			
			VehicleType vecType = new VehicleType(1, "train");

			
			Mockito.when(vtservice.addVehicleType(Mockito.any(VehicleType.class))).thenReturn(vecType);

			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/1.0/vecType")
					.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			
			System.out.println("response"+result.getResponse().getContentAsString());
			
			System.out.println("sttaus"+response.getStatus());
			
			assertEquals(HttpStatus.CREATED.value(), response.getStatus());

			

		}
		
		
	
}
