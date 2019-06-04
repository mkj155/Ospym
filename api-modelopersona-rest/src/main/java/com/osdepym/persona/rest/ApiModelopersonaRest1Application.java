package com.osdepym.persona.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"com.osdepym.rest", "com.osdepym.rest.server", "com.osdepym.hibernate.entity"})
@Configuration
@EnableTransactionManagement
@ImportResource("classpath:spring.xml")
public class ApiModelopersonaRest1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiModelopersonaRest1Application.class, args);
	}
	

}
