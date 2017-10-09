package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	// ${xxx}，可以自定义加载application.properties的属性值
	@Value("${db.url}")
	private String value;
	
	@Value("${rsa.key}")
	private String randomKey;
	
	@RequestMapping("/hi")
	public String index() {
		// this.setValue("123");
		return value;
		// return randomKey;
	}

}
