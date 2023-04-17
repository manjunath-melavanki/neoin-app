package com.neoin.neoincloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NeoinCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeoinCloudConfigServerApplication.class, args);
	}

}
