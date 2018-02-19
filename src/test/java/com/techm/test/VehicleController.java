package com.techm.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.techm.transport.vendor.service.VehicleService;


	@RunWith(SpringRunner.class)
	@WebMvcTest(value=VehicleController.class)
	//@ContextConfiguration
	@ContextHierarchy({ @ContextConfiguration(classes = VehicleController.class)})
	public class VehicleController {
		
		

		//VehicleController vc=new VehicleController();
	@Autowired
		private MockMvc mockMvc;

		@MockBean
		VehicleService vservice;
		
		
		
		
		@Test
		public void getVehicleByName() throws Exception
		{
			mockMvc.perform(get("/vec").requestAttr("regNo","KA-1234")).andExpect(status().isOk());
			
		}
		
		
		
		
	
}
