package com.test.controller;

import com.test.entity.Borrow;
import com.test.entity.BorrowDetail;
import com.test.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// 本注解表示配置中取的东西（如链接内容）支持热更新 - 例为下列的@Value与接口/test
@RefreshScope
public class BorrowController {
	@Resource
	private BorrowService borrowService;

	@RequestMapping("/borrow/bothid/{uid}")
	public List<Borrow> getBorrowByUid(@PathVariable int uid){
		return borrowService.getBorrowByUid(uid);
	}

//	@HystrixCommand(fallbackMethod = "onError")    // 使用@HystrixCommand来指定备选方案
	@RequestMapping("/borrow/{uid}")
	public BorrowDetail getBorrowDetail(@PathVariable("uid") int uid){
		System.out.println("[正常方案] 向其他服务获取信息...");
		return  borrowService.getBorrowDetailByUid(uid);
	}

//	// 备选方案，这里直接返回空列表了
//	// 注意参数和返回值要和上面的一致
//	BorrowDetail onError(int uid){
//		System.out.println("[备选方案] 服务发生降级！");
//		return new BorrowDetail(null, Collections.emptyList());
//	}

	@Value("${test.str}")
	private String teststr;

	@RequestMapping("/borrow/test")
	@ResponseBody
	public String test(){
		return teststr;
	}
}
