package com.example;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
	@Autowired
	private static  RestTemplate restTemplate = new RestTemplate();
	private static final Logger log =Logger.getLogger(MyController.class);
	 
	  @RequestMapping("/")
	    public String index() {
	    	log.warn(" called home... ");
	        return "Greetings from Spring Boot!";
	    }
	    
	   
	    @RequestMapping("/callhome")
	    public String callHome() {
	    log.log(Level.INFO, "calling another service " + restTemplate);
	        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", String.class);
	    }
}
