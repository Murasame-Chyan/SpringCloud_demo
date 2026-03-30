package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping("/user/{uid}")
	public User getUserByUid(@PathVariable int uid,
	                         HttpServletRequest request) {
		System.out.println(uid + " " + request.getHeader("Test"));
		return userService.getUserByUid(uid);
	}
}
