package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("swagger")
public class Swagger2TestController {

	@ApiOperation(value = "获取用户列表", notes = "获取用户列表")
	@GetMapping("/test")
	public String swagger1() {
		return "hi";
	}

}
