package com.java.nms_nbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NmsNbiApplication {
	
	@GetMapping("/status") 
	public String getStatus() { 
		return "Device Status: Online"; 
	} 
	@PutMapping("/config") 
	public String updateConfig(@RequestBody String config) { 
		return "Config updated to: " + config; 
	}

	public static void main(String[] args) {
		SpringApplication.run(NmsNbiApplication.class, args);
	}

}
