package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.aixu.meeting.dao")
public class AixuMeetApplication {

	public static void main(String[] args) {
		SpringApplication.run(AixuMeetApplication.class, args);
	}
}
