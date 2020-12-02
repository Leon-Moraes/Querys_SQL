package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class helloWorldController {
	@GetMapping("/app1")
	public String hello1() {                                           
		return "index.html";
	}
	@GetMapping("/app2")
	public String hello2() {                                           
		return "index2.html";
	}
}
