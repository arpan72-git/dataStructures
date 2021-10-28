package com.training.defecttrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DefectsMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefectsMsApplication.class, args);
	}

}
