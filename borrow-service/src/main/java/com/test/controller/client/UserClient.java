package com.test.controller.client;

import com.test.controller.client.impl.UserFallBackClient;
import com.test.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="user-service", fallback=UserFallBackClient.class)    // 声明为user-service服务的HTTP请求客户端
public interface UserClient {
	// 路径保证和其他微服务提供的一致即可
	@RequestMapping("/user/{uid}")
	User getUserById(@PathVariable("uid") int uid);  // 参数和返回值也保持一致
}
