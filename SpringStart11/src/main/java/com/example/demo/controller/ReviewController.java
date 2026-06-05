package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ReviewRegistForm;
import com.example.demo.service.RegistService;

@Controller
public class ReviewController {
	private final RegistService service1;
	private final RegistService service2;
	
	public ReviewController(
	        @Qualifier("registServiceImpl")
	        RegistService service1,
	        @Qualifier("registServiceMock")
	        RegistService service2) {
	    this.service1 = service1;
	    this.service2 = service2;
	}

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

		/**--- 🔥DI実施箇所---*/
		//☠️従来のインスタンス生成
		//	RegistService service = new RegistServiceImpl();
		//	RegistService service = new RegistServiceMock();
		//	String msg = service.regist();
		
		//💡DI　依存性を注入したオブジェクトの使用（フィールドに定義）
			String msg1 = service1.regist();
			String msg2 = service2.regist();

		model.addAttribute("msg", msg1+"・"+msg2);
		return "complete-regist-review";
	}

}