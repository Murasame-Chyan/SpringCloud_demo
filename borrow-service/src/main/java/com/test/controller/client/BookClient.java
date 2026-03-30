package com.test.controller.client;

import com.test.controller.client.impl.BookFallBackClient;
import com.test.controller.client.impl.UserFallBackClient;
import com.test.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="book-service", fallback=BookFallBackClient.class)    // 声明为book-service服务的HTTP请求客户端
public interface BookClient {
	// 路径保证和其他微服务提供的一致即可
	@RequestMapping("/book/{bid}")
	Book getBookById(@PathVariable("bid") int bid);  // 参数和返回值也保持一致
}
