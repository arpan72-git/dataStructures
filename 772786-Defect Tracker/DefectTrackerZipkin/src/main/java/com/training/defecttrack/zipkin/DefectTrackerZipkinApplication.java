package com.training.defecttrack.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class DefectTrackerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefectTrackerZipkinApplication.class, args);
	}
}
