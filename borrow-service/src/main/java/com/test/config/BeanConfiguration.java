package com.test.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// 负载均衡-同一个服务器可以注册很多个端口，应对大量经过Eureka的服务调用时自动均衡负载
// 可在发生了调用的多端口模块处编写调用
// @LoadBalancerClient(value = "user-service",                  // 指定 user-service 服务，调用时此服务都使用指定策略
// 		configuration = LoadBalancerConfiguration.class)    // 指定定义好的配置类 - 随机负载均衡
@Configuration
public class BeanConfiguration {
	@Bean
	// 默认负载均衡方式为轮询 - 即多个端口轮流接受顺序进来的访问请求
	// 使用自定义负载均衡config改为另一种 - 随机负载均衡，具体见LoadBalancerConfiguration
	// 一般不用随机均衡，因为服务挂掉时负载均衡还会尝试访问挂掉的服务
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
