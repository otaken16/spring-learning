package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewDto {
	private Integer restaurantId;
	private String userId;
	private Date visitDate;
	private Double rating;
	private String comment;
}
