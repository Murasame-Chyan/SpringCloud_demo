package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BorrowDetail {
	User user;
	List<Book> books;
}
