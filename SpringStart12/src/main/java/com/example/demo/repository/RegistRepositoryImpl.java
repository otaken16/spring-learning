package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReviewDto;

@Repository
public class RegistRepositoryImpl implements RegistRepository {

	@Override
	public void add(ReviewDto reviewDto) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("登録完了");
		System.out.println(reviewDto);
	}

}
