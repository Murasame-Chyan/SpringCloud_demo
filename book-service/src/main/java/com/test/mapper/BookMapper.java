package com.test.mapper;

import com.test.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
	@Select("SELECT * FROM book WHERE bid=#{bid}")
	public Book getBookByBid(int bid);
}
