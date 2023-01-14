package com.assignment2.project2;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Controller
public class myController {

	    @GetMapping("/branches")
		public String nameHandler() {
	      return "branches";
		}
		@GetMapping("/services")
		public String addresHandler() {
	      return "services";
		}
		
		
		@GetMapping("/health")
		@ResponseBody
		public String health()  {
	 
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<Map> response = restTemplate.getForEntity("http://localhost:8084/actuator/health", Map.class);
	        Map<String, Object> respMap = response.getBody();
	 
	        String status = (String) respMap.get("status");
	 
	        if (status.equals("UP")) {
	 
	            return "Application UP";
	        }
	 
	        return "Application DOWN";
	 
	    }
	}

