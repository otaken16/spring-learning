package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ReviewRegistForm;

@Controller
public class ReviewController {
	
	/*--- レビュー登録画面表示リクエスト ---*/
	@GetMapping("/show-review-form")
	public String showReviewForm() {
		return "regist-review";
	}
	
	/*--- レビュー登録リクエスト（登録画面より） ---*/
	@PostMapping("/regist-review")
	public String registReview(@ModelAttribute ReviewRegistForm form) {
		System.out.println(form);
		return "confirm-regist-review";
	}
}
