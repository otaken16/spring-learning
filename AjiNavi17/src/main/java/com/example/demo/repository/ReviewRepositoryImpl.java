package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ReviewDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
	
	private final JdbcTemplate jdbc;

	@Override
	public void add(ReviewDto reviewDto) {
		
		String sql = "INSERT INTO t_review"+
					"(restaurant_id, user_id, visit_date, rating, comment)"+
					"VALUES(?,?,?,?,?)";
		
		int count = jdbc.update(sql,
				reviewDto.getRestaurantId(),
				reviewDto.getUserId(),
				reviewDto.getVisitDate(),
				reviewDto.getRating(),
				reviewDto.getComment()
				);
		System.out.println(count+"件　登録完了");
		System.out.println(reviewDto);
	}

}
