package com.capg.pbms.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy

public class PbmsZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbmsZuulApiGatewayApplication.class, args);
	}

}
