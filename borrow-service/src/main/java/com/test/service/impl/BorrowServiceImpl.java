package com.test.service.impl;

//import com.test.controller.client.BookClient;
//import com.test.controller.client.UserClient;
import com.test.controller.client.BookClient;
import com.test.controller.client.UserClient;
import com.test.entity.Book;
import com.test.entity.Borrow;
import com.test.entity.BorrowDetail;
import com.test.entity.User;
import com.test.mapper.BorrowMapper;
import com.test.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
	@Resource
	private BorrowMapper borrowMapper;
//	@Resource
//	private RestTemplate restTemplate;
	@Resource
	private UserClient userClient;
	@Resource
	private BookClient bookClient;
	@Override
	public List<Borrow> getBorrowByUid(int uid){
		return borrowMapper.getBorrowByUid(uid);
	}
	@Override
	public BorrowDetail getBorrowDetailByUid(int uid){
		List<Borrow> borrow = borrowMapper.getBorrowByUid(uid);
		// RestTemplate支持多种方式的远程调用
		// 可通过Eureka注册的服务器来调用模块功能
		// 也可以把远程调用的部分集合进OpenFeign依赖的写法 controller/client下写接口实现如下，需要引入依赖
//		User user = restTemplate.getForObject("http://user-service/user/"+uid, User.class);
//		List<Book> bookList = borrow
//				.stream()
//				.map(b -> restTemplate.getForObject("http://book-service/book/"+b.getBid(), Book.class))
//				.toList();
		User user = userClient.getUserById(uid);
		List<Book> bookList = borrow
				.stream()
				.map(b -> bookClient.getBookById(b.getBid()))
				.toList();

		return new BorrowDetail(user, bookList);
	}
}
