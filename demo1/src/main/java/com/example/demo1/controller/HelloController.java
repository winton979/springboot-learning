package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
