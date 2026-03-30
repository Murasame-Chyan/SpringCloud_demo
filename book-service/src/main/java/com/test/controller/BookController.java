package com.test.controller;

import com.test.entity.Book;
import com.test.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Resource
	private BookService bookService;

	@RequestMapping("/book/{bid}")
	public Book getBookByBid(@PathVariable int bid) {
		return bookService.getBookByBid(bid);
	}
}
