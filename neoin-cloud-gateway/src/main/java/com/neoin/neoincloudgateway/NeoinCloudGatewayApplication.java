package com.neoin.neoincloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NeoinCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeoinCloudGatewayApplication.class, args);
	}

}
