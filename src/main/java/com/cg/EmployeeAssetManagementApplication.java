package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class EmployeeAssetManagementApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeAssetManagementApplication.class, args);
	}

}
