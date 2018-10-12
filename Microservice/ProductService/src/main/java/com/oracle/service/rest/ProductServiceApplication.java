package com.oracle.service.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.oracle.service.config.ProductServiceConfiguration;

@EnableAutoConfiguration //DB CONFIG
@Import(ProductServiceConfiguration.class)  //DB CONFIG
@SpringBootApplication
public class ProductServiceApplication {
    public static void main(String[] args) {
    	SpringApplication.run(ProductServiceApplication.class, args);
    }
}