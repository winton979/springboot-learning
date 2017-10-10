package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	
	@GetMapping(value="/index")
	public String index(ModelMap model) {
		model.addAttribute("host", "feeling t.");
		return "index";
	}
	
}
