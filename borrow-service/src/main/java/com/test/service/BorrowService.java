package com.test.service;

import com.test.entity.Borrow;
import com.test.entity.BorrowDetail;

import java.util.List;

public interface BorrowService {
	List<Borrow> getBorrowByUid(int uid);

	BorrowDetail getBorrowDetailByUid(int uid);
}
