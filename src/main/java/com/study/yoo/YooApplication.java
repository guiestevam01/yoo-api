package com.study.yoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class YooApplication {

	public static void main(String[] args) {
		SpringApplication.run(YooApplication.class, args);
	}

}
