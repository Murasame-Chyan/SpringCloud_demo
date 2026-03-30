package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
//
@EnableFeignClients     // 启用OpenFeignClients服务
//@EnableHystrix          // 启用Hystrix
@SpringBootApplication
public class BorrowApplication {
	public static void main(String[] args) {
		SpringApplication.run(BorrowApplication.class, args);
	}
}
