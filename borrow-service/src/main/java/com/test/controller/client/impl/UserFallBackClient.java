package com.test.controller.client.impl;

import com.test.controller.client.UserClient;
import com.test.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class UserFallBackClient implements UserClient {
	@Override
	public User getUserById(@PathVariable("uid") int uid){
		System.out.println("[备选方案] 服务发生降级！");
		User user = new User();
		user.setName("Bad request!");
		return user;
	}
}
