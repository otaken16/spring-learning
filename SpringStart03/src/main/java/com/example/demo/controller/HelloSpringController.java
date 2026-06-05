package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloSpringController {
	
	//⭐️「localhost/8080/」が来る想定で
	//   クライアントが要求した「/hello」のファイルを
	//   認識できるようにするためアノテーションを指定する
	@GetMapping("/hello")
	
	public String hello() {
		// HTMLテンプレートにhello-spring.htmlを指定
		// =>戻り値のHTMLファイルをしている
		return "hello-spring";
	}
}
