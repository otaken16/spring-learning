package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@GetMapping("/input")
	public String input(Model model) {
		model.addAttribute("test","お試しModelへの格納");
		model.addAttribute("test2","お試しModelへの格納2");
		return "input";
	}
	
	@PostMapping("/post-param")
	public String postParam(@RequestParam(name = "greeting") String greeting,Model model) {
		model.addAttribute("postGreeting",greeting);
		return "display";
	}
}
