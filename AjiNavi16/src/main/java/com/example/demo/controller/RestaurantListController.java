package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Restaurant;
import com.example.demo.form.RestaurantSearchForm;

@Controller
public class RestaurantListController {
	//	最初のリクエスト
	@GetMapping("/top")
	public String restaurantList(@ModelAttribute RestaurantSearchForm restaurantSearchForm) {
		return "restaurant-list";
	}

	//	検索リクエスト
	@PostMapping("/restaurant-search")
	public String restaurantSearch(@ModelAttribute RestaurantSearchForm restaurantSearchForm,Model model) {

		List<Restaurant> list = new ArrayList<>();
		list.add(new Restaurant(1,"店舗1","キャッチ1",3.5));
		list.add(new Restaurant(2,"店舗2","キャッチ2",0.0));
		list.add(new Restaurant(3,"店舗3","キャッチ3",4.4444));
		list.add(new Restaurant(4,"店舗4","キャッチ4",1));
		
		model.addAttribute("restaurantList",list);
		
		return "restaurant-list";
	}
}
