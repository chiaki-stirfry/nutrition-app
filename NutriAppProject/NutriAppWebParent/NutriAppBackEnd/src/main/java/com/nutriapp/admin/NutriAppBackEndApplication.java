package com.nutriapp.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EntityScan({"com.nutriapp.common.entity", "com.nutriapp.admin.user"})
public class NutriAppBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutriAppBackEndApplication.class, args);
	}
	

}
