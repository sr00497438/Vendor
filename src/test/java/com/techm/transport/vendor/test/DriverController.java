package com.techm.transport.vendor.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
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
import org.springframework.http.HttpHeaders;
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
import com.techm.transport.vendor.entity.Driver;
//import com.techm.transport.vendor.controller.DriverController;
import com.techm.transport.vendor.entity.Vehicle;
import com.techm.transport.vendor.service.DriverService;
import com.techm.transport.vendor.service.VehicleService;
import com.techm.transport.vendor.service.VehicleTypeService;
import com.techm.transport.vendor.service.VehicleVerificationService;


	//@SuppressWarnings("deprecation")
	@RunWith(SpringRunner.class)
	@WebMvcTest(value=com.techm.transport.vendor.test.DriverController.class)	
	@ContextConfiguration(classes={VendorApplication.class})
	public class DriverController {
		
		

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
		//@Test
		/*public void getDriverByName() throws Exception
		{
			
			Mockito.when(dservice.getDribyId(1)).thenReturn(dri); 
			
	
			//RequestBuilder rb=MockMvcRequestBuilders.get("/transport/1.0/vec/KA-123").accept(MediaType.APPLICATION_JSON);
					
				//	MockMvcRequestBuilders.get("/students/Student1/courses/Course1").accept(MediaType.APPLICATION_JSON); 
			
              MockHttpServletResponse result= mockMvc.perform(get("/transport/1.0/dri/1").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();	
              
              System.out.println("result is"+result.getContentAsString());
              assertThat(result.getStatus()).isEqualTo(HttpStatus.OK.value());
              
              //assertThat(result.getContentAsString().equals(null));
		}*/
		
		
		@Test
		public void getDriverByNamePost() throws Exception
		{
		
			String exampleCourseJson = "{\"id\":\"1\",\"driName\":\"sample1\",\"license_number\":\"qwert2123\",\"mobile_number\":\"789\",\"address\":\"Vskp\"}";

			
			
			Driver dri = new Driver(1, "user1", "APKSR1234", "9876546541", "Bang");

			
			Mockito.when(dservice.addDriver(Mockito.any(Driver.class))).thenReturn(true);

			
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/transport/1.0/dri")
					.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();

			MockHttpServletResponse response = result.getResponse();

			
			System.out.println("response"+result.getResponse().getContentAsString());
			assertEquals(HttpStatus.CREATED.value(), response.getStatus());

			//assertEquals("http://localhost/transport/1.0/dri//1",
					//response.getHeader(HttpHeaders.LOCATION));

		}
			
			
		/*	//MockHttpServletResponse response = mockMvc.perform(post("/transport/1.0/vec").contentType(MediaType.APPLICATION_JSON).content(jsonSuperHero.write(new Vehicle("KA-123456", 11, 10, "not-valid")).getJson())).andReturn().getResponse();
			
			MockHttpServletResponse response = mockMvc.perform(post("/transport/1.0/dri").contentType(MediaType.APPLICATION_JSON).content(jsonSuperHero.write(new Driver("user1", "APKSR1234", "9876546541", "Bang")).getJson())).andReturn().getResponse();
			//MockHttpServletResponse response = mockMvc.perform(post("/transport/1.0/dri/1/user2/ap123/123/vzm").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
			System.out.println("post res is"+response.getErrorMessage());
			assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value()); */

		
		}

