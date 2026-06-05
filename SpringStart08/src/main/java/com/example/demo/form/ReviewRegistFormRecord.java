package com.example.demo.form;

import java.sql.Date;

public record ReviewRegistFormRecord(
		 Integer restaurantId,
		 Integer userId,
		 Date visitDate,
		 Double rating,
		 String comment
		) {
	
}
