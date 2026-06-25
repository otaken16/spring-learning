package com.example.demo.form;

import java.sql.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class ReviewRegistForm {
	@NotNull(message = "入力がありません。")
	@Min(value = 1, message = "正の整数で入力してください。")
	private Integer restaurantId;

	@NotNull(message = "入力がありません。")
	@Size(min = 4, max = 8, message = "4文字から8文字の間で半角数字を入力してください。")
	private String userId;

	@Past(message = "今日以前の日付を指定してください。")
	private Date visitDate;

	@NotNull(message = "入力がありません。")
	@Min(value = 1, message = "1-5で指定してください。")
	@Max(value = 5, message = "1-5で指定してください。")
	private Double rating;

	@Size(min = 1, max = 128, message = "1文字から128文字の範囲で入力してください。")
	private String comment;
}
