package com.test.mapper;

import com.test.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
	// 查询
	@Select("SELECT * FROM borrow WHERE uid=#{uid}")
	public List<Borrow> getBorrowByUid(int uid);

	@Select("SELECT * FROM borrow WHERE bid=#{bid}")
	public List<Borrow> getBorrowByBid(int bid);

	@Select("SELECT * FROM borrow WHERE uid=#{uid} AND bid=#{bid}")
	public List<Borrow> getBorrowByBidAndUid(int uid, int bid);
}
