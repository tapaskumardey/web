package com.oracle.service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.oracle.service.config.CustomerServiceConfiguration;

@EnableAutoConfiguration //DB CONFIG
@Import(CustomerServiceConfiguration.class)  //DB CONFIG
@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
    	SpringApplication.run(CustomerServiceApplication.class, args);
    }
}