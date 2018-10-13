package com.shop.service.order.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan
@SpringBootApplication
public class ServiceConfiguration {
    public static void main(String[] args) {
    	SpringApplication.run(ServiceConfiguration.class, args);
    }
    
    @Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}