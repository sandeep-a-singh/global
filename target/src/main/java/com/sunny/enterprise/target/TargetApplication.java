package com.sunny.enterprise.target;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScans(@ComponentScan(basePackages = "com.sunny.enterprise"))
public class TargetApplication {
	private static final Logger LOGGER = LogManager.getLogger(TargetApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TargetApplication.class, args);

		LOGGER.info("Application Started "+ TargetApplication.class.getCanonicalName());
	}

}
