package com.capg.pbms.account_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class PbmsAccountManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PbmsAccountManagementSystemApplication.class, args);
	}

}
