package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Restaurant;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepository {
	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<Restaurant> selectByNameWildcard(String restaurantName) {

		//		SELECT文作成
		String sql = "SELECT  "
				+ "  mr.restaurant_id,  "
				+ "  mr.restaurant_name, "
				+ "  mr.catch_phrase, "
				+ "  COALESCE(AVG(tr.rating),0.0) average_rating "
				+ "FROM "
				+ "  m_restaurant mr "
				+ "  LEFT OUTER JOIN t_review tr "
				+ "      ON mr.restaurant_id = tr.restaurant_id "
				+ "WHERE "
				+ "  mr.restaurant_name LIKE ? "
				+ "GROUP BY "
				+ "  mr.restaurant_id, "
				+ "  mr.restaurant_name, "
				+ "  mr.catch_phrase "
				+ "ORDER BY "
				+ "  mr.restaurant_id ";

		//  SQL　プレースホルダーの設定
		String p = "%" + restaurantName + "%";
		// SQL検索実行
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, p);

		// 検索結果を取得
		List<Restaurant> result = new ArrayList<>();
		for (Map<String, Object> li : list) {
			Restaurant r = new Restaurant();
			r.setRestaurantId((int) li.get("restaurant_id"));
			r.setRestaurantName((String) li.get("restaurant_name"));
			r.setCatchPhrase((String) li.get("catch_phrase"));
			double d = ((BigDecimal) li.get("average_rating")).doubleValue();
			r.setAverageRating(d);
			result.add(r);
		}
		
		return result;

	}

}
