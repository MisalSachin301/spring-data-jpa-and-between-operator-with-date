package com.heaptrace;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class SpringBootAppTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppTestApplication.class, args);
	}

//	@PostConstruct
//	public void init(){
//		// Setting Spring Boot SetTimeZone
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//	}

}
