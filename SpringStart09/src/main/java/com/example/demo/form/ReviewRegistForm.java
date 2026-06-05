package com.example.demo.form;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewRegistForm {
	private Integer restaurantId;
	private String userId;
	private Date visitDate;
	private Double rating;
	private String comment;
}
