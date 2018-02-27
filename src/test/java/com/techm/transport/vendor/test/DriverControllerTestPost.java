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
import com.techm.transport.vendor.controller.DriverController;
import com.techm.transport.vendor.entity.Driver;
import com.techm.transport.vendor.service.DriverService;
import com.techm.transport.vendor.service.VehicleService;
import com.techm.transport.vendor.service.VehicleTypeService;
import com.techm.transport.vendor.service.VehicleVerificationService;


	//@SuppressWarnings("deprecation")
	@RunWith(SpringRunner.class)
	@WebMvcTest(value=com.techm.transport.vendor.test.DriverControllerTestPost.class)	
	@ContextConfiguration(classes={VendorApplication.class})
	public class DriverControllerTestPost {
		
		

		//VehicleController vc=new VehicleController();
		
	   @Autowired
		private MockMvc mockMvc;
	    
	    
		@MockBean
	    private DriverController vcontroller;
		
		
		@MockBean		
		private DriverService dservice;
		
		@MockBean		
		private VehicleTypeService vtservice;
		
		@MockBean		
		private VehicleVerificationService vvservice;
		
		@MockBean
		private VehicleService service;
		
		
		private JacksonTester<Driver> jsonSuperHero;
		
		Driver dri = new Driver(1, "user1", "APKSR1234", "9876546541", "Bang");
		
		
		@Before
		public void setup()
		{
			
			JacksonTester.initFields(this,new ObjectMapper()); 
		}
		
		@Test
		public void getDriverByNamePost() throws Exception
		{
		
			String exampleCourseJson = "{\"id1\":\"1\",\"driName\":\"user1\",\"license_number\":\"APKSR1234\",\"mobile_number\":\"9876546541\",\"address\":\"Bang\"}";

			
			
			Driver dri = new Driver(1, "user1", "APKSR1234", "9876546541", "Bang");

			
			Mockito.when(dservice.addDriver(Mockito.any(Driver.class))).thenReturn(dri);
			
            
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/1/0/dri")
					.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			
			System.out.println("sttaus"+response.getStatus());
			
			assertEquals(HttpStatus.CREATED, response.getStatus());

			}
			
		
		
		}

