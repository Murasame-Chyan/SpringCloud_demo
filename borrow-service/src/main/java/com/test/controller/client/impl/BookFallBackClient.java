package com.test.controller.client.impl;

import com.test.controller.client.BookClient;
import com.test.entity.Book;
import com.test.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class BookFallBackClient implements BookClient {
	@Override
	public Book getBookById(@PathVariable("bid") int bid){
		System.out.println("[备选方案] 服务发生降级！");
		Book book = new Book();
		book.setTitle("Bad Request!");
		return book;
	}
}
