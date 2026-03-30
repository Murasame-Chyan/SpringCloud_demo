package com.test.service.impl;

import com.test.entity.Book;
import com.test.mapper.BookMapper;
import com.test.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	@Resource
	private BookMapper bookMapper;

	@Override
	public Book getBookByBid(int bid) {
		return bookMapper.getBookByBid(bid);
	}
}
