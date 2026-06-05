package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.ReviewDto;
import com.example.demo.form.ReviewRegistForm;
import com.example.demo.service.RegistService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReviewController {
	private final RegistService service;

	/**--- ⭐️レビュー登録画面表示リクエスト ---*/
	@GetMapping("show-review-form")
	public String showReviewForm(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}

	/**--- ⭐️レビュー登録画面表示リクエスト （確認画面から戻るボタン押下）---*/
	@PostMapping("show-review-form-ret")
	public String showReviewFormRet(@ModelAttribute ReviewRegistForm form) {
		return "regist-review";
	}

	/**--- ⭐️レビュー登録リクエスト（登録画面から確認画面へ） ---*/
	@PostMapping("regist-review")
	public String registReview(
			@Validated @ModelAttribute ReviewRegistForm form,
			BindingResult result) {

		if (result.hasErrors())
			return "regist-review";

		return "confirm-regist-review";
	}

	/**--- ⭐️レビュー登録リクエスト （確認画面から登録画面へ）---*/
	@PostMapping("confirm-regist-review")
	public String confirmRegistReview(
			@Validated @ModelAttribute ReviewRegistForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "regist-review";

		ReviewDto r = new ReviewDto();
		r.setRestaurantId(form.getRestaurantId());
		r.setUserId(form.getUserId());
		r.setVisitDate(form.getVisitDate());
		r.setRating(form.getRating());
		r.setComment(form.getComment());
		service.regist(r);

		model.addAttribute("msg", "登録完了しました。");
		return "complete-regist-review";
	}

}