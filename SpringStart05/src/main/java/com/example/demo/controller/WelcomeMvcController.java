package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeMvcController {

	//🔥01.Modelオブジェクトでの作成方法
	@GetMapping("/welcome-m")
	public String welcomeM(Model model) {
		//　addAttribute("属性名","値")
		model.addAttribute("greeting", "Hello");
		model.addAttribute("welcome", "WelcomeMVC（Modelオブジェクト）");
		return "welcome-mvc"; //⭐️同じHTMLテンプレートを使用する
	}

	//🔥02.ModelAndViewオブジェクトでの作成方法
	@GetMapping("/welcome-mv")
	public ModelAndView welcomeMV(ModelAndView mav) {
		//　addObject("属性名","値")
		mav.addObject("greeting", "Hello");
		mav.addObject("welcome", "WelcomeMVC（ModelAndViewオブジェクト）");

		mav.setViewName("welcome-mvc");//⭐️同じHTMLテンプレートを使用する
		return mav;
	}

}
