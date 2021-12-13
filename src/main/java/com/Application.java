package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controller.VilleController;


@SpringBootApplication
public class Application {
	private static Logger logger = LoggerFactory.getLogger(VilleController.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("Application START !");
		
	}
}
