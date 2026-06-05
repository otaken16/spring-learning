package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeSpringController {
	@GetMapping("/welcome")
	public String welcome() {
		// HTMLテンプレートに"welcome-spring.html"を指定
		return "welcome-spring";
	}
	
}
