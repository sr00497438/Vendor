package com.techm.transport.vendor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class VendorApplication {  
	public static void main(String[] args) {
		SpringApplication.run(VendorApplication.class, args);
    } 
	
	@Bean
	public SimpleCORSFilter corsFilter(){
		return new SimpleCORSFilter();
	}
}            
