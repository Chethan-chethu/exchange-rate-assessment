package com.echange.currencyexhange.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// configuration , where we can define beans for the application
@Configuration
public class EchangeConfiguration {

	@Bean
	public RestTemplate restTemplate() {
	 return new RestTemplate();	
	}
	
}
