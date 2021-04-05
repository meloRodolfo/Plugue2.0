package com.uff.plugue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class PlugueApplication extends WebMvcConfigurationSupport{

	public static void main(String[] args) {
		SpringApplication.run(PlugueApplication.class, args);
	}

}
