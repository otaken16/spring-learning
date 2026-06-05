package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ReviewRegistForm;

@Controller
public class ReviewController {
	@GetMapping("/show-review-form")
	public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}
	
	@PostMapping("/regist-review")
	public String registReview(@ModelAttribute ReviewRegistForm form) {
		System.out.println("内容確認："+form);
		return "confirm-regist-review";
		
	}
	
	@PostMapping("/complete-regist-ret")
	public String registReviewRet(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}
	
	@PostMapping("/complete-regist-review")
	public String completeRegistReview(@ModelAttribute ReviewRegistForm form) {
		System.out.println("登録完了："+form);
		return "/complete-regist-review";
	}
	
}
