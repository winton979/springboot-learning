package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.common.exception.MyException;

@RestController
public class HelloController {
	
	// ${xxx}，可以自定义加载application.properties的属性值
	@Value("${db.url}")
	private String value;
	
	@Value("${rsa.key}")
	private String randomKey;
	
	@GetMapping("/hi")
	public String index() {
		// this.setValue("123"); // 修改值后覆盖value
		return value;
		// return randomKey; // 获取随机值，每次启动项目值随机。
	}
	
	@GetMapping("/e")
	public String exception(Integer i) {
		// 测试异常处理器
		i.byteValue();
		return null;
	}
	
	@GetMapping("/e2")
	public String exception2(Integer i) throws MyException {
		// 测试自定义异常处理器
		throw new MyException("");
	}

}
