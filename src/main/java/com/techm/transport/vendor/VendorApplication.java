package com.techm.transport.vendor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VendorApplication {  
	public static void main(String[] args) {
		SpringApplication.run(VendorApplication.class, args);
    } 
	
	@Bean
	public SimpleCORSFilter corsFilter(){
		return new SimpleCORSFilter();
	}
}

@RefreshScope
@RestController
class MessageRestController {

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}